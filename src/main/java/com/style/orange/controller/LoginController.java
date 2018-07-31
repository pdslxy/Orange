package com.style.orange.controller;

import com.style.orange.enums.OrangeResultCode;
import com.style.orange.exception.OrangeException;
import com.style.orange.model.SysUser;
import com.style.orange.service.SysUserService;
import com.style.orange.shiro.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Li
 * @create 2018-07-12 14:47
 * @desc 登录controller
 **/

@RestController
@Api("登录接口")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

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

}
