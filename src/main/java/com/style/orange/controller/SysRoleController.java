package com.style.orange.controller;

import com.style.orange.service.SysRoleService;
import com.style.orange.vo.SysRoleVoForSave;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Mr.Li
 * @create 2018-07-10 14:05
 * @desc 角色web层
 **/
@RestController
@RequestMapping("/sysRole")
@Api(tags={"角色接口"})
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PutMapping("/saveOrUpdate")
    @ApiOperation("保存或更新角色")
    @RequiresPermissions({"sys:role:save", "sys:role:update"})
    public void saveOrUpdate(SysRoleVoForSave sysRoleVoForSave) {
        sysRoleService.saveOrUpdate(sysRoleVoForSave);
    }

    @PutMapping("/grantResource")
    @ApiOperation("给角色赋予权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色Id", required = true),
            @ApiImplicitParam(name = "resourceIds", value = "资源Id(多个用,分隔)", required = true)
    })
    public void grantResource(@RequestParam String roleId, @RequestParam String resourceIds) {
        String[] resourceIdArr = resourceIds.split(",");
        sysRoleService.grantResource(roleId, Arrays.asList(resourceIdArr));
    }

}
