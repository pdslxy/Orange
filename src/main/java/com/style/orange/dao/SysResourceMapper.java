package com.style.orange.dao;

import com.style.orange.model.SysResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Li
 */
@Component
public interface SysResourceMapper {

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);


    /**
     * 新增
     *
     * @param record
     * @return
     */
    int insert(SysResource record);


    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    SysResource selectByPrimaryKey(String id);


    /**
     * 查询所有
     *
     * @return
     */
    List<SysResource> selectAll();


    /**
     * 根据id更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysResource record);


    /**
     * 根据角色Id查询
     *
     * @param roleId
     * @return
     */
    List<SysResource> selectByRoleId(@Param("roleId") String roleId);

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    List<SysResource> selectByUserName(@Param("username") String username);
}