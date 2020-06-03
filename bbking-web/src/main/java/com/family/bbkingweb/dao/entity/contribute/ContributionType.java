package com.family.bbkingdao.entity.contribute;

import java.io.Serializable;
import java.util.Date;

public class ContributionType implements Serializable {
    private static final long serialVersionUID = -1830333098231896072L;
    private String id;
    private String typeName;
    private String flag;
    private String createTime;
    private String creator;
    private String modifiedTime;
    private String modifior;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifior() {
        return modifior;
    }

    public void setModifior(String modifior) {
        this.modifior = modifior;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }
}
