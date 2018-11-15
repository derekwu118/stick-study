package com.derek.stick.spider.weibo.module;

import java.util.List;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class Mblog {

    /**
     * id
     */
    private String        id;
    /**
     * idStr
     */
    private String        idStr;
    /**
     * mid
     */
    private String        mid;
    /**
     * source
     */
    private String        source;
    /**
     * text
     */
    private String        text;
    /**
     * textLength
     */
    private Integer       textLength;
    /**
     * picStatus
     */
    private String        picStatus;
    /**
     * pics
     */
    private List<PicInfo> pics;
    /**
     * reposts_count
     */
    private Long          repostsCount;
    /**
     * comments_count 评论个数
     */
    private Long          commentsCount;
    /**
     * original_pic
     */
    private String        originalPic;
    /**
     * thumbnail_pic
     */
    private String        thumbnailPic;
    /**
     * attitudes_count
     */
    private Integer       attitudesCount;
    /**
     * bid
     */
    private String        bid;
    /**
     * can_edit
     */
    private Boolean       canEdit;
    /**
     * cardid
     */
    private String        cardId;

    /**
     * content_auth
     */
    private String        contentAuth;
    /**
     * created_at
     */
    private String        createdAt;
    /**
     * edit_config
     */
    private EditConfig    editConfig;
    /**
     * extern_safe
     */
    private Integer       externSafe;
    /**
     * favorited
     */
    private Boolean       favorited;
    /**
     * hide_flag
     */
    private Integer       hideFlag;
    /**
     * isLongText
     */
    private Boolean       isLongText;
    /**
     * is_paid
     */
    private Boolean       isPaid;
    /**
     * mblog_vip_type
     */
    private Integer       mblogVipType;
    /**
     * mblogtype
     */
    private Integer       mblogType;
    /**
     * more_info_type
     */
    private String        moreInfoType;
    /**
     * obj_ext
     */
    private String        objExt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTextLength() {
        return textLength;
    }

    public void setTextLength(Integer textLength) {
        this.textLength = textLength;
    }

    public String getPicStatus() {
        return picStatus;
    }

    public void setPicStatus(String picStatus) {
        this.picStatus = picStatus;
    }

    public List<PicInfo> getPics() {
        return pics;
    }

    public void setPics(List<PicInfo> pics) {
        this.pics = pics;
    }

    public Long getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(Long repostsCount) {
        this.repostsCount = repostsCount;
    }

    public Long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getOriginalPic() {
        return originalPic;
    }

    public void setOriginalPic(String originalPic) {
        this.originalPic = originalPic;
    }

    public String getThumbnailPic() {
        return thumbnailPic;
    }

    public void setThumbnailPic(String thumbnailPic) {
        this.thumbnailPic = thumbnailPic;
    }

    public Integer getAttitudesCount() {
        return attitudesCount;
    }

    public void setAttitudesCount(Integer attitudesCount) {
        this.attitudesCount = attitudesCount;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getContentAuth() {
        return contentAuth;
    }

    public void setContentAuth(String contentAuth) {
        this.contentAuth = contentAuth;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public EditConfig getEditConfig() {
        return editConfig;
    }

    public void setEditConfig(EditConfig editConfig) {
        this.editConfig = editConfig;
    }

    public Integer getExternSafe() {
        return externSafe;
    }

    public void setExternSafe(Integer externSafe) {
        this.externSafe = externSafe;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Integer getHideFlag() {
        return hideFlag;
    }

    public void setHideFlag(Integer hideFlag) {
        this.hideFlag = hideFlag;
    }

    public Boolean getLongText() {
        return isLongText;
    }

    public void setLongText(Boolean longText) {
        isLongText = longText;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Integer getMblogVipType() {
        return mblogVipType;
    }

    public void setMblogVipType(Integer mblogVipType) {
        this.mblogVipType = mblogVipType;
    }

    public Integer getMblogType() {
        return mblogType;
    }

    public void setMblogType(Integer mblogType) {
        this.mblogType = mblogType;
    }

    public String getMoreInfoType() {
        return moreInfoType;
    }

    public void setMoreInfoType(String moreInfoType) {
        this.moreInfoType = moreInfoType;
    }

    public String getObjExt() {
        return objExt;
    }

    public void setObjExt(String objExt) {
        this.objExt = objExt;
    }

    public static class EditConfig {

        /**
         * edited
         */
        private Boolean edited;

        public EditConfig() {
        }

        public EditConfig(Boolean edited) {
            this.edited = edited;
        }

        public Boolean getEdited() {
            return edited;
        }

        public void setEdited(Boolean edited) {
            this.edited = edited;
        }
    }

    public static class PicInfo {

        private String   pid;
        private String   size;
        private String   url;
        private Geo      geo;
        private PicLarge large;

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        public PicLarge getLarge() {
            return large;
        }

        public void setLarge(PicLarge large) {
            this.large = large;
        }
    }

    public static class Geo {

        private Boolean croped;
        private Integer height;
        private Integer width;

        public Boolean getCroped() {
            return croped;
        }

        public void setCroped(Boolean croped) {
            this.croped = croped;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }
    }

    public static class PicLarge {

        private Geo    geo;
        private String size;
        private String url;

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
