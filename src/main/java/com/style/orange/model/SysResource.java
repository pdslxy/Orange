package com.style.orange.model;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Mr.Li
 */
public class SysResource implements Serializable{


    private static final long serialVersionUID = 1022487788072679200L;

    private String id;

    private String parentId;


    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private String type;


    private String description;


    private String url;


    private String perms;


    private Date createDate;


    private Date updateDate;


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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        return "SysResource{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", perms='" + perms + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createUserId='" + createUserId + '\'' +
                ", updateUserId='" + updateUserId + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}