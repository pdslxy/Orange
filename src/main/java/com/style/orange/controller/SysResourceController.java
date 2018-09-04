package com.style.orange.controller;

import com.style.orange.service.SysResourceService;
import com.style.orange.vo.SysResourceVoForSave;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Li
 * @create 2018-07-26 19:17
 * @desc 资源接口
 **/
@RestController
@RequestMapping("/sysResource")
@Api(tags={"角色接口"})
public class SysResourceController {

    @Autowired
    private SysResourceService sysResourceService;

    @PutMapping("/saveOrUpdate")
    @ApiOperation("保存或更新资源")
    public void saveOrUpdate(SysResourceVoForSave sysResourceVoForSave) {
        sysResourceService.saveOrUpdate(sysResourceVoForSave);
    }
}
