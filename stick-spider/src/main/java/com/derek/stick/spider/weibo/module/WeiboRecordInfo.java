package com.derek.stick.spider.weibo.module;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class WeiboRecordInfo {

    /**
     * 原始response文本
     */
    private String  originalContent;

    /**
     * card_type = 9 是我们所需要的
     */
    private Integer cardType;
    /**
     * itemid, "_-_" 分隔
     */
    private String  itemId;
    /**
     * show_type
     */
    private Integer showType;
    /**
     * scheme
     */
    private String  scheme;
    /**
     * mblog
     */
    private Mblog   mblog;

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public Mblog getMblog() {
        return mblog;
    }

    public void setMblog(Mblog mblog) {
        this.mblog = mblog;
    }

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }
}
