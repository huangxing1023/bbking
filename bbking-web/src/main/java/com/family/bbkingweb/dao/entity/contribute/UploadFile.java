package com.family.bbkingweb.dao.entity.contribute;

import java.io.Serializable;
import java.util.Date;

public class UploadFile implements Serializable {
    private static final long serialVersionUID = -3031336537270671667L;
    private String id;
    private String url;
    private String path;
    private String type;
    private String size;
    private String creator;
    private String creatorName;
    private String createTime;

    public UploadFile(String id, String url, String path, String creator, String createTime) {
        this.id = id;
        this.url = url;
        this.path = path;
        this.creator = creator;
        this.createTime = createTime;
    }

    public UploadFile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
