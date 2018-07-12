package com.style.orange.vo;

import java.io.Serializable;

/**
 * @author Mr.Li
 * @create 2018-07-11 11:03
 * @desc 角色保存VO
 **/

public class SysRoleVoForSave implements Serializable{

    private static final long serialVersionUID = -1711708639722009466L;
    private String id;

    private String roleName;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SysRoleVoForSave{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
