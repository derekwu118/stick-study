package com.derek.stick.lock.mysql.dal;

import org.apache.ibatis.annotations.Mapper;

import com.derek.stick.lock.mysql.entity.StickLockDO;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
@Mapper
public interface StickLockDAO {

    /**
     * 添加锁
     * 
     * @param stickLockDO
     * @return long
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    long addLock(StickLockDO stickLockDO);

    /**
     * 移除锁
     * 
     * @param lockObj
     * @return long
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    long removeLock(String lockObj);

    /**
     * 获取锁信息
     * 
     * @param lockObj
     * @return com.derek.stick.lock.mysql.entity.StickLockDO
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    StickLockDO getLock(String lockObj);
}
