package com.style.orange.service.impl;

import com.style.orange.dao.SysResourceMapper;
import com.style.orange.model.SysResource;
import com.style.orange.service.SysResourceService;
import com.style.orange.vo.SysResourceVoForSave;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Mr.Li
 * @create 2018-07-26 19:12
 * @desc 资源服务
 **/
@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveOrUpdate(SysResourceVoForSave sysResourceVoForSave) {
        SysResource sysResource = new SysResource();
        BeanUtils.copyProperties(sysResourceVoForSave, sysResource);
        if (StringUtils.isEmpty(sysResourceVoForSave.getId())) {
            sysResource.setCreateDate(new Date());
        } else {
            sysResource.setUpdateDate(new Date());
        }
        sysResourceMapper.insert(sysResource);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<SysResource> findResourceByRoleId(String roleId) {
        return sysResourceMapper.selectByRoleId(roleId);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<SysResource> findResourceByUserName(String username) {
        return sysResourceMapper.selectByUserName(username);
    }

}
