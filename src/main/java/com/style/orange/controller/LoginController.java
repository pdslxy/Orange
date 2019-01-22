package com.style.orange.controller;

import com.alibaba.fastjson.JSON;
import com.style.orange.enums.OrangeResultCode;
import com.style.orange.exception.OrangeException;
import com.style.orange.model.SysUser;
import com.style.orange.service.SysUserService;
import com.style.orange.shiro.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Mr.Li
 * @create 2018-07-12 14:47
 * @desc 登录controller
 **/

@RestController
@Api(tags = {"登录接口"})
public class LoginController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/login/{username}/{password}")
    @ApiOperation("登录")
    public String login(@PathVariable("username") String username, @PathVariable("password") String password) {
        SysUser sysUser = sysUserService.findByUserName(username);
        if (sysUser.getPassword().equals(password)) {
            String token = JwtUtil.sign(username, password);
            return token;
        } else {
            throw new OrangeException(OrangeResultCode.ERROR_PWD);
        }
    }

    @GetMapping("/login/redisTest")
    @ApiOperation("redisTest")
    public void redisTest() {
        List<SysUser> list = new ArrayList<>();
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("xixi");
        list.add(sysUser);
        list.add(sysUser);
        stringRedisTemplate.opsForHash().put("123", "asd", JSON.toJSONString(list));
        List<SysUser> userList = JSON.parseArray(stringRedisTemplate.opsForHash().get("123", "asd").toString(), SysUser.class);
        System.out.println(userList);
    }

    @GetMapping("/login/getInfo")
    @ApiOperation("getInfo")
    public Map<String, Object> getInfo() {
        Map<String, Object> map = new HashMap<>(2);
        Map<String, Object> map2 = new HashMap<>(3);
        map2.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map2.put("name","admin");
        map2.put("roles", Arrays.asList("admin"));
        map.put("code",20000);
        map.put("data",map2);
        return map;
    }
}
