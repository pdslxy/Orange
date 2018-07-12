package com.style.orange.vo;

import java.io.Serializable;

/**
 * @author Mr.Li
 * @create 2018-07-12 10:16
 * @desc 系统用户保存Vo
 **/
public class SysUserVoForSave implements Serializable {
    private static final long serialVersionUID = -4169249786965150790L;

    private String id;

    private String loginName;

    private String userName;

    private String password;

    private Integer status;

    private String roleId;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysUserVoForSave{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", roleId='" + roleId + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
