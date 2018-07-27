package com.style.orange.service;

import com.style.orange.model.SysResource;
import com.style.orange.vo.SysResourceVoForSave;

import java.util.List;

/**
 * @author Mr.Li
 * @create 2018-07-26 19:00
 * @desc 资源接口
 **/
public interface SysResourceService {

    /**
     * 保存或更新
     *
     * @param sysResourceVoForSave
     */
    void saveOrUpdate(SysResourceVoForSave sysResourceVoForSave);

    /**
     * 查找角色的资源
     *
     * @param roleId
     * @return
     */
    List<SysResource> findResourceByRoleId(String roleId);

    /**
     * 根据用户名查找资源
     *
     * @param username
     * @return
     */
    List<SysResource> findResourceByUserName(String username);
}
