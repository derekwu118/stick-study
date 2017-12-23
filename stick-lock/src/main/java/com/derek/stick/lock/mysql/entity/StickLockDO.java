package com.derek.stick.lock.mysql.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
public class StickLockDO implements Serializable {

    private Long   id;
    private Date   gmtCreate;
    private Date   gmtModified;
    /**
     * 加锁对象
     */
    private String lockObj;
    /**
     * 过期时长
     */
    private Long   expireDuration;
    /**
     * 过期时间（解锁时间）
     */
    private Date   expireTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLockObj() {
        return lockObj;
    }

    public void setLockObj(String lockObj) {
        this.lockObj = lockObj;
    }

    public Long getExpireDuration() {
        return expireDuration;
    }

    public void setExpireDuration(Long expireDuration) {
        this.expireDuration = expireDuration;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "StickLockDO{" + "id=" + id + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", lockObj='"
               + lockObj + '\'' + ", expireDuration=" + expireDuration + ", expireTime=" + expireTime + '}';
    }
}
