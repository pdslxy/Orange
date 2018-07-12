package com.style.orange.dao;

import com.style.orange.model.SysRole;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr.Li
 */
@Component
public interface SysRoleMapper {

    /**
     * 根据Id删除
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
    int insert(SysRole record);

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    SysRole selectByPrimaryKey(String id);

    /**
     * 查询所有
     *
     * @return
     */
    List<SysRole> selectAll();

    /**
     * 根据Id更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysRole record);
}