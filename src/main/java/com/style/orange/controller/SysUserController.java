package com.style.orange.controller;

import com.style.orange.service.SysUserService;
import com.style.orange.vo.SysUserVoForSave;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Li
 * @create 2018-07-10 14:05
 * @desc 角色web层
 **/
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PutMapping("/saveOrUpdate")
    @ApiOperation("保存或更新用户")
    public void saveOrUpdate(SysUserVoForSave sysUserVoForSave) {
        sysUserService.saveOrUpdate(sysUserVoForSave);
    }
}
