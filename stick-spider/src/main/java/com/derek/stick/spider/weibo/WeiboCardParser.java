package com.derek.stick.spider.weibo;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.derek.stick.common.serialize.SerializableTool;
import com.derek.stick.spider.weibo.module.Mblog;
import com.derek.stick.spider.weibo.module.WeiboRecordInfo;
import com.google.common.collect.Lists;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class WeiboCardParser {

    public static WeiboRecordInfo parse(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) obj;
        WeiboRecordInfo info = new WeiboRecordInfo();
        info.setCardType(jsonObject.getInteger("card_type"));
        info.setItemId(jsonObject.getString("itemid"));
        info.setScheme(jsonObject.getString("scheme"));
        info.setShowType(jsonObject.getInteger("show_type"));
        info.setMblog(parseMblob(jsonObject.get("mblog")));
        info.setOriginalContent(SerializableTool.serialize(obj));
        return info;
    }

    @SuppressWarnings("all")
    private static Mblog parseMblob(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) obj;
        Mblog mblog = new Mblog();
        mblog.setId(jsonObject.getString("id"));
        mblog.setIdStr(jsonObject.getString("idStr"));
        mblog.setMid(jsonObject.getString("mid"));
        mblog.setSource(jsonObject.getString("source"));
        mblog.setText(jsonObject.getString("text"));
        mblog.setTextLength(jsonObject.getInteger("textLength"));
        mblog.setPicStatus(jsonObject.getString("picStatus"));
        // set pics
        JSONArray picArr = jsonObject.getJSONArray("pics");
        List<Mblog.PicInfo> picInfoList = null;
        if (picArr == null || picArr.isEmpty()) {
            picInfoList = Lists.newArrayList();
        } else {
            picInfoList = (List<Mblog.PicInfo>) SerializableTool.deserialize(SerializableTool.serialize(picArr),
                                                                             Mblog.PicInfo.class);
        }
        mblog.setPics(picInfoList);

        mblog.setRepostsCount(jsonObject.getLong("reposts_count"));
        mblog.setCommentsCount(jsonObject.getLong("comments_count"));
        mblog.setOriginalPic(jsonObject.getString("original_pic"));
        mblog.setThumbnailPic(jsonObject.getString("thumbnail_pic"));
        mblog.setAttitudesCount(jsonObject.getInteger("attitudes_count"));
        mblog.setBid(jsonObject.getString("bid"));
        mblog.setCanEdit(jsonObject.getBoolean("can_edit"));
        mblog.setCardId(jsonObject.getString("cardid"));
        mblog.setContentAuth(jsonObject.getString("content_auth"));
        mblog.setCreatedAt(jsonObject.getString("created_at"));

        // set edit_config
        Mblog.EditConfig editConfig = null;
        Object edgeCfgObj = jsonObject.get("edit_config");
        if (edgeCfgObj != null && (edgeCfgObj instanceof JSONObject)) {
            editConfig = new Mblog.EditConfig(((JSONObject) edgeCfgObj).getBoolean("edited"));
        }
        mblog.setEditConfig(editConfig);

        mblog.setExternSafe(jsonObject.getInteger("extern_safe"));
        mblog.setFavorited(jsonObject.getBoolean("favorited"));
        mblog.setHideFlag(jsonObject.getInteger("hide_flag"));
        mblog.setLongText(jsonObject.getBoolean("isLongText"));
        mblog.setPaid(jsonObject.getBoolean("is_paid"));
        mblog.setMblogVipType(jsonObject.getInteger("mblog_vip_type"));
        mblog.setMblogType(jsonObject.getInteger("mblogtype"));
        mblog.setMoreInfoType(jsonObject.getString("more_info_type"));
        mblog.setObjExt(jsonObject.getString("obj_ext"));
        return mblog;
    }
}
