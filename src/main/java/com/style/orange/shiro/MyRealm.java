package com.style.orange.shiro;

import com.alibaba.fastjson.JSON;
import com.style.orange.constant.OrangeConstant;
import com.style.orange.model.SysResource;
import com.style.orange.model.SysUser;
import com.style.orange.service.SysResourceService;
import com.style.orange.service.SysUserService;
import com.style.orange.utils.JwtUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr.Li
 * @create 2018-07-12 15:23
 * @desc
 **/
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String username = JwtUtil.getUsername(principals.toString());
        List<SysResource> resourceList;
        //从redis缓存中查询权限
        String resourceStr = stringRedisTemplate.opsForValue().get(OrangeConstant.PREFIX_USER_PERMISSION + username);
        if (resourceStr != null) {
            resourceList = JSON.parseArray(resourceStr.toString(), SysResource.class);
        } else {
            //从数据库查询权限放到redis中
            resourceList = sysResourceService.findResourceByUserName(username);
            stringRedisTemplate.opsForValue().set(OrangeConstant.PREFIX_USER_PERMISSION + username, JSON.toJSONString(resourceList));
        }
        stringRedisTemplate.expire(OrangeConstant.PREFIX_USER_PERMISSION + username, OrangeConstant.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
        if (resourceList != null) {
            resourceList.parallelStream().forEach(sysResource -> simpleAuthorizationInfo.addStringPermission(sysResource.getPerms()));
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }

        SysUser userBean = sysUserService.findByUserName(username);
        if (userBean == null) {
            throw new AuthenticationException("用户不存在!");
        }

        if (!JwtUtil.verify(token, username, userBean.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
