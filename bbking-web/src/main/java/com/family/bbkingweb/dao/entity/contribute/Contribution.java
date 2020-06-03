package com.family.bbkingweb.dao.entity.contribute;

import java.io.Serializable;
import java.util.List;

/**
 * 稿件信息
 */
public class Contribution implements Serializable {
    private static final long serialVersionUID = 3123431281322769520L;
    /***
     * 主键
     */
    private String id;

    /****
     * 主题
     */
    private String title;
    /**
     * videoId
     */
    private String videoFieldId;

    /**
     * 视频地址
     */
    private String videoFieldurl;

    /***
     * 投放类别
     */
    private String type;

    /**
     * 视频展示图文件id
     */
    private String imageFieldId;

    /**
     * 视频展示图地址
     */
    private String imageFieldurl;

    /**
     * 观看量
     */
    private int view;

    /**
     * 点赞数
     */
    private int praise;

    /**
     * 投币量
     */
    private int coin;

    /****
     * 有效符
     */
    private String flag;

    /**
     * 说明
     */
    private String remark;

    /**
     * 投稿日期
     */
    private String createTime;

    /***
     * 投稿人
     */
    private String creator;

    /**
     * 投稿人名字
     */
    private String creatorName;

    /**
     * 投稿标签
     */
    private List<ContributionTag> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoFieldId() {
        return videoFieldId;
    }

    public void setVideoFieldId(String videoFieldId) {
        this.videoFieldId = videoFieldId;
    }

    public String getImageFieldId() {
        return imageFieldId;
    }

    public void setImageFieldId(String imageFieldId) {
        this.imageFieldId = imageFieldId;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ContributionTag> getTags() {
        return tags;
    }

    public void setTags(List<ContributionTag> tags) {
        this.tags = tags;
    }

    public String getImageFieldurl() {
        return imageFieldurl;
    }

    public void setImageFieldurl(String imageFieldurl) {
        this.imageFieldurl = imageFieldurl;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getVideoFieldurl() {
        return videoFieldurl;
    }

    public void setVideoFieldurl(String videoFieldurl) {
        this.videoFieldurl = videoFieldurl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
