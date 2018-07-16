package com.style.orange.service.impl;

import com.style.orange.dao.SysUserMapper;
import com.style.orange.model.SysUser;
import com.style.orange.service.SysUserService;
import com.style.orange.vo.SysUserVoForSave;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author Mr.Li
 * @create 2018-07-10 13:58
 * @desc
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveOrUpdate(SysUserVoForSave sysUserVoForSave) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserVoForSave, sysUser);
        sysUser.setUpdateDate(new Date());
        if (StringUtils.hasText(sysUser.getId())) {
            sysUserMapper.updateByPrimaryKey(sysUser);
        } else {
            sysUser.setCreateDate(new Date());
            sysUserMapper.insert(sysUser);
            //保存用户与角色关联关系
            sysUserMapper.insertSysUserRole(sysUser.getId(),sysUserVoForSave.getRoleId());

        }
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public SysUser findByUserName(String username) {
        return sysUserMapper.selectByUserName(username);
    }
}
