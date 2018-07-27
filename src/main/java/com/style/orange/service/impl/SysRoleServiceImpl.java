package com.style.orange.service.impl;

import com.style.orange.dao.SysRoleMapper;
import com.style.orange.dao.SysRoleResourceMapper;
import com.style.orange.model.SysRole;
import com.style.orange.model.SysRoleResource;
import com.style.orange.service.SysRoleService;
import com.style.orange.vo.SysRoleVoForSave;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mr.Li
 * @create 2018-07-10 13:58
 * @desc
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(SysRoleVoForSave sysRoleVoForSave) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleVoForSave, sysRole);
        sysRole.setUpdateDate(new Date());
        if (StringUtils.hasText(sysRole.getId())) {
            sysRoleMapper.updateByPrimaryKey(sysRole);
        } else {
            sysRole.setCreateDate(new Date());
            sysRoleMapper.insert(sysRole);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void grantResource(String roleId, List<String> resourceIdList) {
        List<SysRoleResource> list = resourceIdList.parallelStream().map(resourceId -> {
            SysRoleResource sysRoleResource = new SysRoleResource();
            sysRoleResource.setRoleId(roleId);
            sysRoleResource.setResourceId(resourceId);
            return sysRoleResource;
        }).collect(Collectors.toList());
        sysRoleResourceMapper.batchInsert(list);
    }


}
