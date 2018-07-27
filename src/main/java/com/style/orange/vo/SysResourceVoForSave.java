package com.style.orange.vo;

import java.io.Serializable;

/**
 * @author Mr.Li
 * @create 2018-07-26 19:08
 * @desc 资源保存vo
 **/
public class SysResourceVoForSave implements Serializable {
    private static final long serialVersionUID = -5775955168845302026L;

    private String id;

    private String parentId;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private String type;


    private String description;


    private String url;


    private String perms;


    private String createUserId;


    private String updateUserId;


    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SysResourceVoForSave{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", perms='" + perms + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", updateUserId='" + updateUserId + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
