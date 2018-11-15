package com.derek.stick.spider.weibo.module;

import java.util.List;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class CommentInfo {

    /**
     * 原始response文本
     */
    private String            originalContent;

    /**
     * max
     */
    private Long              max;
    /**
     * max_id
     */
    private Long              maxId;
    /**
     * max_id_type
     */
    private Integer           maxIdType;
    /**
     * status
     */
    private Status            status;
    /**
     * 
     */
    private List<CommentItem> commentItemList;

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public Integer getMaxIdType() {
        return maxIdType;
    }

    public void setMaxIdType(Integer maxIdType) {
        this.maxIdType = maxIdType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<CommentItem> getCommentItemList() {
        return commentItemList;
    }

    public void setCommentItemList(List<CommentItem> commentItemList) {
        this.commentItemList = commentItemList;
    }

    public static class CommentItem {

        /**
         * bid
         */
        private String           bid;
        /**
         * comments instance Boolean
         */
        private Boolean          comments;
        /**
         * comments instance of List
         */
        private List<SubComment> subComments;
        /**
         * created_at
         */
        private String           createdAt;
        /**
         * disable_reply
         */
        private Integer          disableReply;
        /**
         * floor_number
         */
        private Long             floorNumber;
        /**
         * id
         */
        private String           id;
        /**
         * isLikedByMblogAuthor
         */
        private Boolean          isLikedByMblogAuthor;
        /**
         * like_count
         */
        private Long             likeCount;
        /**
         * liked
         */
        private Boolean          liked;
        /**
         * max_id
         */
        private Long             maxId;
        /**
         * mid
         */
        private String           mid;
        /**
         * more_info_type
         */
        private Integer          moreInfoType;
        /**
         * rootid
         */
        private String           rootId;
        /**
         * source
         */
        private String           source;
        /**
         * text
         */
        private String           text;
        /**
         * total_number
         */
        private Integer          totalNumber;
        /**
         * user
         */
        private UserInfo         user;

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public Boolean getComments() {
            return comments;
        }

        public void setComments(Boolean comments) {
            this.comments = comments;
        }

        public List<SubComment> getSubComments() {
            return subComments;
        }

        public void setSubComments(List<SubComment> subComments) {
            this.subComments = subComments;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getDisableReply() {
            return disableReply;
        }

        public void setDisableReply(Integer disableReply) {
            this.disableReply = disableReply;
        }

        public Long getFloorNumber() {
            return floorNumber;
        }

        public void setFloorNumber(Long floorNumber) {
            this.floorNumber = floorNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getLikedByMblogAuthor() {
            return isLikedByMblogAuthor;
        }

        public void setLikedByMblogAuthor(Boolean likedByMblogAuthor) {
            isLikedByMblogAuthor = likedByMblogAuthor;
        }

        public Long getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(Long likeCount) {
            this.likeCount = likeCount;
        }

        public Boolean getLiked() {
            return liked;
        }

        public void setLiked(Boolean liked) {
            this.liked = liked;
        }

        public Long getMaxId() {
            return maxId;
        }

        public void setMaxId(Long maxId) {
            this.maxId = maxId;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public Integer getMoreInfoType() {
            return moreInfoType;
        }

        public void setMoreInfoType(Integer moreInfoType) {
            this.moreInfoType = moreInfoType;
        }

        public String getRootId() {
            return rootId;
        }

        public void setRootId(String rootId) {
            this.rootId = rootId;
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

        public Integer getTotalNumber() {
            return totalNumber;
        }

        public void setTotalNumber(Integer totalNumber) {
            this.totalNumber = totalNumber;
        }

        public UserInfo getUser() {
            return user;
        }

        public void setUser(UserInfo user) {
            this.user = user;
        }
    }

    public static class SubComment {

        /**
         * bid
         */
        private String   bid;
        /**
         * created_at
         */
        private String   createdAt;
        /**
         * disable_reply
         */
        private Integer  disableReply;
        /**
         * floor_number
         */
        private Integer  floorNumber;
        /**
         * id
         */
        private String   id;
        /**
         * mid
         */
        private String   mid;
        /**
         * rootid
         */
        private String   rootId;
        /**
         * shouldShowColon
         */
        private Integer  shouldShowColon;
        /**
         * source
         */
        private String   source;
        /**
         * text
         */
        private String   text;
        /**
         * user
         */
        private UserInfo user;

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getDisableReply() {
            return disableReply;
        }

        public void setDisableReply(Integer disableReply) {
            this.disableReply = disableReply;
        }

        public Integer getFloorNumber() {
            return floorNumber;
        }

        public void setFloorNumber(Integer floorNumber) {
            this.floorNumber = floorNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getRootId() {
            return rootId;
        }

        public void setRootId(String rootId) {
            this.rootId = rootId;
        }

        public Integer getShouldShowColon() {
            return shouldShowColon;
        }

        public void setShouldShowColon(Integer shouldShowColon) {
            this.shouldShowColon = shouldShowColon;
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

        public UserInfo getUser() {
            return user;
        }

        public void setUser(UserInfo user) {
            this.user = user;
        }
    }

    public static class UserInfo {

        /**
         * avatar_hd
         */
        private String  avatarHd;
        /**
         * cover_image_phone
         */
        private String  coverImagePhone;
        /**
         * description
         */
        private String  description;
        /**
         * follow_count
         */
        private Long    followCount;
        /**
         * follow_me
         */
        private Boolean followMe;
        /**
         * followers_count
         */
        private Long    followersCount;
        /**
         * following
         */
        private Boolean following;
        /**
         * gender
         */
        private String  gender;
        /**
         * id
         */
        private String  id;
        /**
         * like
         */
        private Boolean like;
        /**
         * like_me
         */
        private Boolean likeMe;
        /**
         * mbrank
         */
        private Integer mbrank;
        /**
         * mbtype
         */
        private Integer mbtype;
        /**
         * profile_image_url
         */
        private String  profileImageUrl;
        /**
         * profile_url
         */
        private String  profileUrl;
        /**
         * screen_name
         */
        private String  screenName;
        /**
         * statuses_count
         */
        private Long    statusesCount;
        /**
         * urank
         */
        private Integer urank;
        /**
         * verified
         */
        private Boolean verified;
        /**
         * verified_type
         */
        private Integer verifiedType;

        public String getAvatarHd() {
            return avatarHd;
        }

        public void setAvatarHd(String avatarHd) {
            this.avatarHd = avatarHd;
        }

        public String getCoverImagePhone() {
            return coverImagePhone;
        }

        public void setCoverImagePhone(String coverImagePhone) {
            this.coverImagePhone = coverImagePhone;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Long getFollowCount() {
            return followCount;
        }

        public void setFollowCount(Long followCount) {
            this.followCount = followCount;
        }

        public Boolean getFollowMe() {
            return followMe;
        }

        public void setFollowMe(Boolean followMe) {
            this.followMe = followMe;
        }

        public Long getFollowersCount() {
            return followersCount;
        }

        public void setFollowersCount(Long followersCount) {
            this.followersCount = followersCount;
        }

        public Boolean getFollowing() {
            return following;
        }

        public void setFollowing(Boolean following) {
            this.following = following;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getLike() {
            return like;
        }

        public void setLike(Boolean like) {
            this.like = like;
        }

        public Boolean getLikeMe() {
            return likeMe;
        }

        public void setLikeMe(Boolean likeMe) {
            this.likeMe = likeMe;
        }

        public Integer getMbrank() {
            return mbrank;
        }

        public void setMbrank(Integer mbrank) {
            this.mbrank = mbrank;
        }

        public Integer getMbtype() {
            return mbtype;
        }

        public void setMbtype(Integer mbtype) {
            this.mbtype = mbtype;
        }

        public String getProfileImageUrl() {
            return profileImageUrl;
        }

        public void setProfileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
        }

        public String getProfileUrl() {
            return profileUrl;
        }

        public void setProfileUrl(String profileUrl) {
            this.profileUrl = profileUrl;
        }

        public String getScreenName() {
            return screenName;
        }

        public void setScreenName(String screenName) {
            this.screenName = screenName;
        }

        public Long getStatusesCount() {
            return statusesCount;
        }

        public void setStatusesCount(Long statusesCount) {
            this.statusesCount = statusesCount;
        }

        public Integer getUrank() {
            return urank;
        }

        public void setUrank(Integer urank) {
            this.urank = urank;
        }

        public Boolean getVerified() {
            return verified;
        }

        public void setVerified(Boolean verified) {
            this.verified = verified;
        }

        public Integer getVerifiedType() {
            return verifiedType;
        }

        public void setVerifiedType(Integer verifiedType) {
            this.verifiedType = verifiedType;
        }
    }

    public static class Status {

        /**
         * comment_manage_info
         */
        private CommentManageInfo commentManageInfo;
        /**
         * total_number
         */
        private Long              totalNumber;

        public CommentManageInfo getCommentManageInfo() {
            return commentManageInfo;
        }

        public void setCommentManageInfo(CommentManageInfo commentManageInfo) {
            this.commentManageInfo = commentManageInfo;
        }

        public Long getTotalNumber() {
            return totalNumber;
        }

        public void setTotalNumber(Long totalNumber) {
            this.totalNumber = totalNumber;
        }

        public static class CommentManageInfo {

            /**
             * approval_comment_type
             */
            private Integer approvalCommentType;
            /**
             * comment_permission_type
             */
            private Integer commentPermissionType;

            public Integer getApprovalCommentType() {
                return approvalCommentType;
            }

            public void setApprovalCommentType(Integer approvalCommentType) {
                this.approvalCommentType = approvalCommentType;
            }

            public Integer getCommentPermissionType() {
                return commentPermissionType;
            }

            public void setCommentPermissionType(Integer commentPermissionType) {
                this.commentPermissionType = commentPermissionType;
            }
        }
    }
}
