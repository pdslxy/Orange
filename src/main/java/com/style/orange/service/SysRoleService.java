package com.style.orange.service;

import com.style.orange.vo.SysRoleVoForSave;

import java.util.List;

/**
 * @author Mr.Li
 * @create 2018-07-10 13:58
 * @desc 角色接口
 **/
public interface SysRoleService {
    /**
     * 保存或更新
     *
     * @param sysRoleVoForSave
     */
    void saveOrUpdate(SysRoleVoForSave sysRoleVoForSave);

    /**
     * 赋予权限
     *
     * @param roleId
     * @param resourceIdList
     */
    void grantResource(String roleId, List<String> resourceIdList);



}
