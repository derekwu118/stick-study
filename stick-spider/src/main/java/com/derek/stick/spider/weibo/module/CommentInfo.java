package com.derek.stick.spider.weibo.module;

import java.util.List;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class CommentInfo {

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
    private Long              maxIdType;
    /**
     * status
     */
    private Status            status;

    private List<CommentItem> commentItemList;

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

    public Long getMaxIdType() {
        return maxIdType;
    }

    public void setMaxIdType(Long maxIdType) {
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
        private String   bid;
        /**
         * comments
         */
        private Boolean  comments;
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
        private Long     floorNumber;
        /**
         * id
         */
        private String   id;
        /**
         * isLikedByMblogAuthor
         */
        private Boolean  isLikedByMblogAuthor;
        /**
         * like_count
         */
        private Long     likeCount;
        /**
         * liked
         */
        private Boolean  liked;
        /**
         * max_id
         */
        private Long     maxId;
        /**
         * mid
         */
        private String   mid;
        /**
         * more_info_type
         */
        private Integer  moreInfoType;
        /**
         * rootid
         */
        private String   rootId;
        /**
         * source
         */
        private String   source;
        /**
         * text
         */
        private String   text;
        /**
         * total_number
         */
        private Integer  totalNumber;
        /**
         * user
         */
        private UserInfo user;
    }

    private static class UserInfo {

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
