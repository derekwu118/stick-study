package com.derek.stick.lock.mysql.service;

import com.derek.stick.lock.mysql.entity.StickMySqlLockBO;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
public interface MySqlLockService {

    /**
     * 加锁
     * 
     * @param lockObj
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    Boolean lock(String lockObj);

    /**
     * 加锁，带加锁时长
     * 
     * @param lockObj
     * @param lockTime
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    Boolean lock(String lockObj, Long lockTime);

    /**
     * 解锁
     * 
     * @param lockObj
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    Boolean unlock(String lockObj);

    /**
     * 获取lock信息
     * 
     * @param lockObj
     * @return com.derek.stick.lock.mysql.entity.StickMySqlLockBO
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    StickMySqlLockBO getLockInfo(String lockObj);

    /**
     * 加锁
     * 
     * @param stickMySqlLockBO
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    Boolean addLockInfo(StickMySqlLockBO stickMySqlLockBO);

    /**
     * 移除锁信息
     * 
     * @param lockObj
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    Boolean removeLockInfo(String lockObj);
}
