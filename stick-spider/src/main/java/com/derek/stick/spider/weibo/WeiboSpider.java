package com.derek.stick.spider.weibo;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.derek.stick.common.util.http.HttpConfiguration;
import com.derek.stick.common.util.http.HttpResult;
import com.derek.stick.common.util.http.HttpTinyTool;
import com.derek.stick.spider.weibo.module.CommentInfo;
import com.derek.stick.spider.weibo.module.WeiboRecordInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class WeiboSpider {

    private static final String CARD_REQ_URL = "https://m.weibo.cn/api/container/getIndex";
    private static final String COMMENT_URL  = "https://m.weibo.cn/comments/hotflow";

    private HttpTinyTool        httpTinyTool;
    private WeiboDbWriter       dbWriter;

    private String              uid;
    private String              containerId;

    public WeiboSpider(String uid, String containerId) {
        Preconditions.checkNotNull(uid, "uid cannot be null.");
        Preconditions.checkNotNull(containerId, "containerId cannot be null.");
        this.uid = uid;
        this.containerId = containerId;
        httpTinyTool = new HttpTinyTool(new HttpConfiguration());
    }

    public WeiboSpider(String uid, String containerId, WeiboDbWriter dbWriter) {
        this(uid, containerId);
        Preconditions.checkNotNull(dbWriter, "dbWriter cannot be null.");
        this.dbWriter = dbWriter;
    }

    public List<WeiboRecordInfo> getPage(int page) {
        HttpResult result = httpTinyTool.httpGet(CARD_REQ_URL, buildGetIndexParams(uid, containerId, page),
                                                 getHeaders(uid));
        if (!result.isSuccessful()) {
            return null;
        }
        JSONObject data = JSONObject.parseObject(result.getContent());
        JSONObject innerData = data.getJSONObject("data");
        if (innerData == null) {
            return null;
        }
        List<Object> cardObjList = innerData.getJSONArray("cards");
        if (cardObjList == null || cardObjList.size() == 0) {
            return null;
        }
        List<WeiboRecordInfo> recordInfoList = Lists.newLinkedList();
        for (Object cardObj : cardObjList) {
            WeiboRecordInfo recordInfo = WeiboCardParser.parse(cardObj);
            if (recordInfo != null) {
                recordInfoList.add(recordInfo);
            }
        }
        return recordInfoList;
    }

    public void getPageAndWrite2Db(int page) {
        HttpResult result = httpTinyTool.httpGet(CARD_REQ_URL, buildGetIndexParams(uid, containerId, page),
                                                 getHeaders(uid));
        if (!result.isSuccessful()) {
            return;
        }
        JSONObject data = JSONObject.parseObject(result.getContent());
        JSONObject innerData = data.getJSONObject("data");
        if (innerData == null) {
            return;
        }
        List<Object> cardObjList = innerData.getJSONArray("cards");
        if (cardObjList == null || cardObjList.size() == 0) {
            return;
        }
        for (Object cardObj : cardObjList) {
            WeiboRecordInfo recordInfo = WeiboCardParser.parse(cardObj);
            if (recordInfo != null && recordInfo.getMblog() != null) {
                Long dbId = dbWriter.writeWeiboRecord(recordInfo);
                if (dbId != null) {
                    // 查询评论 （TODO by derek.wq: 异步线程查询评论，线程池控制）
                    iterateComments(dbId, recordInfo.getMblog().getId(), recordInfo.getMblog().getMid(), null, 0);
                }
            }
        }
    }

    /**
     * 迭代的获取评论
     * 
     * @param
     * @return void
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2018-11-15
     * </PRE>
     */
    public void iterateComments(Long dbId, String id, String mid, Long maxId, Integer maxIdType) {
        if (id == null || mid == null) {
            return;
        }
        HttpResult result = httpTinyTool.httpGet(COMMENT_URL, buildGetCommentParams(id, mid, maxId, maxIdType),
                                                 getHeaders(uid));
        if (!result.isSuccessful()) {
            return;
        }
        JSONObject data = JSONObject.parseObject(result.getContent());
        JSONObject innerData = data.getJSONObject("data");
        if (innerData == null) {
            return;
        }
        CommentInfo commentInfo = CommentParser.parse(innerData);
        if (commentInfo == null) {
            return;
        }
        // 写db
        dbWriter.writeComment(dbId, id, mid, commentInfo);
        if (commentInfo.getMaxId() != null && commentInfo.getMaxId() > 0) {
            // maxId > 0 ， 继续迭代查询评论
            iterateComments(dbId, id, mid, commentInfo.getMaxId(), commentInfo.getMaxIdType());
        }
    }

    private Map<String, String> buildGetIndexParams(String uid, String containerId, int page) {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(4);
        map.put("type", "uid");
        map.put("value", uid);
        map.put("containerid", containerId);
        map.put("page", String.valueOf(page));
        return map;
    }

    private Map<String, String> buildGetCommentParams(String id, String mid, Long maxId, Integer maxIdType) {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(4);
        map.put("id", id);
        map.put("mid", mid);
        if (maxId != null) {
            map.put("max_id", String.valueOf(maxId));
        }
        if (maxIdType == null) {
            map.put("max_id_type", "0");
        } else {
            map.put("max_id_type", String.valueOf(maxIdType));
        }
        return map;
    }

    private Map<String, String> getHeaders(String uid) {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(5);
        map.put("Host", "m.weibo.cn");
        map.put("Referer", "https://m.weibo.cn/u/" + uid);
        map.put("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36");
        map.put("Accept", "application/json, text/plain, */*");
        map.put("X-Requested-With", "XMLHttpRequest");
        return map;
    }
}
