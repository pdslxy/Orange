package com.style.orange.controller;

import com.style.orange.service.SysRoleService;
import com.style.orange.vo.SysRoleVoForSave;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Li
 * @create 2018-07-10 14:05
 * @desc 角色web层
 **/
@RestController
@RequestMapping("/sysRole")
@Api("角色接口")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("/saveOrUpdate")
    @ApiOperation("保存或更新角色")
    public void saveOrUpdate(SysRoleVoForSave sysRoleVoForSave) {
        sysRoleService.saveOrUpdate(sysRoleVoForSave);
    }
}
