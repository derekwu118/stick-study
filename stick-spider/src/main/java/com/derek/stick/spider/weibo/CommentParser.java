package com.derek.stick.spider.weibo;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.derek.stick.common.serialize.SerializableTool;
import com.derek.stick.spider.weibo.module.CommentInfo;
import com.google.common.collect.Lists;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class CommentParser {

    public static CommentInfo parse(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) obj;
        CommentInfo comment = new CommentInfo();
        comment.setMax(jsonObject.getLong("max"));
        comment.setMaxId(jsonObject.getLong("max_id"));
        comment.setMaxIdType(jsonObject.getInteger("max_id_type"));

        // set status
        comment.setStatus(parseStatus(jsonObject.get("status")));
        comment.setCommentItemList(parseData(jsonObject.get("data")));
        comment.setOriginalContent(SerializableTool.serialize(obj));
        return comment;
    }

    private static CommentInfo.Status parseStatus(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) obj;
        CommentInfo.Status status = new CommentInfo.Status();
        status.setTotalNumber(jsonObject.getLong("total_number"));
        status.setCommentManageInfo(parseCommentManageInfo(jsonObject.get("comment_manage_info")));
        return status;
    }

    private static CommentInfo.Status.CommentManageInfo parseCommentManageInfo(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) obj;
        CommentInfo.Status.CommentManageInfo info = new CommentInfo.Status.CommentManageInfo();
        info.setApprovalCommentType(jsonObject.getInteger("approval_comment_type"));
        info.setCommentPermissionType(jsonObject.getInteger("comment_permission_type"));
        return info;
    }

    private static List<CommentInfo.CommentItem> parseData(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;
            return Lists.newArrayList(parseCommentItem(jsonObject));
        } else if (obj instanceof JSONArray) {
            JSONArray array = (JSONArray) obj;
            List<CommentInfo.CommentItem> itemList = Lists.newArrayListWithExpectedSize(array.size());
            for (Object subObj : array) {
                CommentInfo.CommentItem item = parseCommentItem(subObj);
                if (item != null) {
                    itemList.add(item);
                }
            }
            return itemList;
        }
        return null;
    }

    private static CommentInfo.CommentItem parseCommentItem(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) obj;
        CommentInfo.CommentItem item = new CommentInfo.CommentItem();
        item.setBid(jsonObject.getString("bid"));

        // set comments / subComments
        Object commentsObj = jsonObject.get("comments");
        if (commentsObj != null) {
            if (commentsObj instanceof Boolean) {
                item.setComments((Boolean) commentsObj);
            } else if (commentsObj instanceof List) {
                List<Object> subCommentObjList = (List<Object>) commentsObj;
                if (!subCommentObjList.isEmpty()) {
                    List<CommentInfo.SubComment> subCommentList = Lists.newArrayListWithExpectedSize(subCommentObjList.size());
                    for (Object subCommentObj : subCommentObjList) {
                        CommentInfo.SubComment subComment = parseSubComment(subCommentObj);
                        if (subComment != null) {
                            subCommentList.add(subComment);
                        }
                    }
                    item.setSubComments(subCommentList);
                }
            }
        }

        // set createAt
        item.setCreatedAt(jsonObject.getString("created_at"));
        item.setDisableReply(jsonObject.getInteger("disable_reply"));
        item.setFloorNumber(jsonObject.getLong("floor_number"));
        item.setId(jsonObject.getString("id"));
        item.setLikedByMblogAuthor(jsonObject.getBoolean("isLikedByMblogAuthor"));
        item.setLikeCount(jsonObject.getLong("like_count"));
        item.setLiked(jsonObject.getBoolean("liked"));
        item.setMaxId(jsonObject.getLong("max_id"));
        item.setMid(jsonObject.getString("mid"));
        item.setMoreInfoType(jsonObject.getInteger("more_info_type"));
        item.setRootId(jsonObject.getString("rootid"));
        item.setSource(jsonObject.getString("source"));
        item.setText(jsonObject.getString("text"));
        item.setTotalNumber(jsonObject.getInteger("total_number"));

        // set user
        item.setUser(parseUser(jsonObject.get("user")));
        return item;
    }

    private static CommentInfo.SubComment parseSubComment(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) obj;
        CommentInfo.SubComment comment = new CommentInfo.SubComment();
        comment.setBid(jsonObject.getString("bid"));
        comment.setCreatedAt(jsonObject.getString("created_at"));
        comment.setDisableReply(jsonObject.getInteger("disable_reply"));
        comment.setFloorNumber(jsonObject.getInteger("floor_number"));
        comment.setId(jsonObject.getString("id"));
        comment.setMid(jsonObject.getString("mid"));
        comment.setRootId(jsonObject.getString("rootid"));
        comment.setShouldShowColon(jsonObject.getInteger("shouldShowColon"));
        comment.setSource(jsonObject.getString("source"));
        comment.setText(jsonObject.getString("text"));
        comment.setUser(parseUser(jsonObject.get("user")));
        return comment;
    }

    private static CommentInfo.UserInfo parseUser(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) obj;
        CommentInfo.UserInfo info = new CommentInfo.UserInfo();
        info.setAvatarHd(jsonObject.getString("avatar_hd"));
        info.setCoverImagePhone(jsonObject.getString("cover_image_phone"));
        info.setDescription(jsonObject.getString("description"));
        info.setFollowCount(jsonObject.getLong("follow_count"));
        info.setFollowMe(jsonObject.getBoolean("follow_me"));
        info.setFollowersCount(jsonObject.getLong("followers_count"));
        info.setFollowing(jsonObject.getBoolean("following"));
        info.setGender(jsonObject.getString("gender"));
        info.setId(jsonObject.getString("id"));
        info.setLike(jsonObject.getBoolean("like"));
        info.setLikeMe(jsonObject.getBoolean("like_me"));
        info.setMbrank(jsonObject.getInteger("mbrank"));
        info.setMbtype(jsonObject.getInteger("mbtype"));
        info.setProfileImageUrl(jsonObject.getString("profile_image_url"));
        info.setProfileUrl(jsonObject.getString("profile_url"));
        info.setScreenName(jsonObject.getString("screen_name"));
        info.setStatusesCount(jsonObject.getLong("statuses_count"));
        info.setUrank(jsonObject.getInteger("urank"));
        info.setVerified(jsonObject.getBoolean("verified"));
        info.setVerifiedType(jsonObject.getInteger("verified_type"));
        return info;
    }

}
