package com.derek.stick.spider.weibo;

import com.derek.stick.spider.weibo.module.CommentInfo;
import com.derek.stick.spider.weibo.module.WeiboRecordInfo;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public interface WeiboDbWriter {

    Long writeWeiboRecord(WeiboRecordInfo recordInfo);

    void writeComment(Long dbId, String recordId, String recordMid, CommentInfo commentInfo);
}
