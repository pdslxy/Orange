package com.style.orange.model;

import java.io.Serializable;

/**
 * @author Mr.Li
 * @create 2018-07-12 10:22
 * @desc 用户与角色关系
 **/
public class SysUserRole implements Serializable {


    private static final long serialVersionUID = -8483544767293915927L;

    private String id;

    private String roleId;

    private String userId;
}
