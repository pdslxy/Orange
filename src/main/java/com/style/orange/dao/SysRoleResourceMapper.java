package com.style.orange.dao;

import com.style.orange.model.SysRoleResource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Li
 */
@Component
public interface SysRoleResourceMapper {

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
    int insert(SysRoleResource record);

    /**
     * 批量插入
     *
     * @param list
     */
    void batchInsert(List<SysRoleResource> list);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    SysRoleResource selectByPrimaryKey(String id);

    /**
     * 查询所有
     *
     * @return
     */
    List<SysRoleResource> selectAll();

    /**
     * 根据id更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysRoleResource record);
}