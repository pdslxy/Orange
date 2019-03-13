package com.style.orange.controller;

import com.style.orange.exception.OrangeException;
import com.style.orange.model.SysUser;
import com.style.orange.service.SysUserService;
import com.style.orange.vo.SysUserVoForSave;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.Li
 * @create 2018-07-10 14:05
 * @desc 角色web层
 **/
@RestController
@RequestMapping("/sysUser")
@Api(tags = {"用户接口"})
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PutMapping("/saveOrUpdate")
    @ApiOperation("保存或更新用户")
    @RequiresPermissions({"sys:user:save", "sys:user:update"})
    public void saveOrUpdate(SysUserVoForSave sysUserVoForSave) {
        sysUserService.saveOrUpdate(sysUserVoForSave);
    }

    @GetMapping("/findAll")
    @ApiOperation("查询所有用户")
    @RequiresPermissions({"sys:user:get"})
    public List<SysUser> findAll() {
        return sysUserService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除用户")
    @RequiresPermissions({"sys:user:delete"})
    public void delete(@PathVariable("id") String id) {
        try {
            sysUserService.deleteUser(id);
        } catch (Exception e) {
            OrangeException.throwException(e);
        }
    }
}
