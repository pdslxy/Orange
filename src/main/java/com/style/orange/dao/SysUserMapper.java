package com.style.orange.dao;

import com.style.orange.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Li
 */
@Component
public interface SysUserMapper {

    /**
     * 根据Id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入
     *
     * @param record
     * @return
     */
    int insert(SysUser record);

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(String id);

    /**
     * 查询所有
     *
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据Id更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 保存用户与角色关系
     *
     * @param id     用户id
     * @param roleId
     */
    void insertSysUserRole(@Param("userId") String id, @Param("roleId") String roleId);

    /**
     * 删除用户与角色关系
     *
     * @param userId     用户id
     */
    void deleteSysUserRole(@Param("userId") String userId);

    /**
     * 根据登录名查询用户
     *
     * @param username
     * @return
     */
    SysUser selectByUserName(String username);

}