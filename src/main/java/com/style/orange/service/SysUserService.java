package com.style.orange.service;

import com.style.orange.model.SysUser;
import com.style.orange.vo.SysUserVoForSave;

/**
 * @author Mr.Li
 * @create 2018-07-10 13:58
 * @desc 用户接口
 **/
public interface SysUserService {
    /**
     * 保存或更新
     *
     * @param sysUserVoForSave
     */
    void saveOrUpdate(SysUserVoForSave sysUserVoForSave);


    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    SysUser findByUserName(String username);
}
