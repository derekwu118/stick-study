package com.derek.stick.lock.mysql.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derek.stick.common.serialize.SerializableTool;
import com.derek.stick.lock.mysql.dal.StickLockDAO;
import com.derek.stick.lock.mysql.entity.StickLockDO;
import com.derek.stick.lock.mysql.entity.StickMySqlLockBO;
import com.derek.stick.lock.mysql.util.MySqlLockUtil;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
@Service
public class MySqlLockServiceImpl implements MySqlLockService {

    private static final Logger logger = LoggerFactory.getLogger(MySqlLockServiceImpl.class);

    @Autowired
    private StickLockDAO        stickLockDAO;

    @Override
    public Boolean lock(String lockObj) {
        if (StringUtils.isBlank(lockObj)) {
            logger.error("lockObj is null.");
            return false;
        }
        StickMySqlLockBO stickMySqlLockBO = new StickMySqlLockBO();
        stickMySqlLockBO.setLockObj(lockObj);
        return addLockInfo(stickMySqlLockBO);
    }

    @Override
    public Boolean lock(String lockObj, Long lockTime) {
        if (StringUtils.isBlank(lockObj)) {
            logger.error("lockObj is null.");
            return false;
        }
        if (lockTime == null || lockTime == 0) {
            return lock(lockObj);
        }
        StickMySqlLockBO stickMySqlLockBO = new StickMySqlLockBO();
        stickMySqlLockBO.setLockObj(lockObj);
        stickMySqlLockBO.setExpireDuration(lockTime);
        Date expireTime = new Date(new Date().getTime() + lockTime);
        stickMySqlLockBO.setExpireTime(expireTime);
        return addLockInfo(stickMySqlLockBO);
    }

    @Override
    public Boolean unlock(String lockObj) {
        if (StringUtils.isBlank(lockObj)) {
            logger.error("lockObj is null.");
            return false;
        }
        if (getLockInfo(lockObj) == null) {
            return true;
        }
        return removeLockInfo(lockObj);
    }

    @Override
    public StickMySqlLockBO getLockInfo(String lockObj) {
        if (StringUtils.isBlank(lockObj)) {
            logger.warn("lockObj is null.");
            return null;
        }
        StickLockDO stickLockDO = stickLockDAO.getLock(lockObj);
        return MySqlLockUtil.transform2StickLockBO(stickLockDO);
    }

    @Override
    public Boolean addLockInfo(StickMySqlLockBO stickMySqlLockBO) {
        if (stickMySqlLockBO == null) {
            return false;
        }
        if (StringUtils.isBlank(stickMySqlLockBO.getLockObj())) {
            return false;
        }
        StickMySqlLockBO oldLockBO = getLockInfo(stickMySqlLockBO.getLockObj());
        if (oldLockBO != null && isExpire(oldLockBO.getExpireTime())) {
            boolean removeExpireLock = removeLockInfo(oldLockBO.getLockObj());
            if (!removeExpireLock) {
                logger.error("remove expire lock failed. lockObj: {}", stickMySqlLockBO.getLockObj());
                return false;
            }
        }
        StickLockDO stickLockDO = MySqlLockUtil.transform2StickLockDO(stickMySqlLockBO);
        try {
            long rs = stickLockDAO.addLock(stickLockDO);
            if (rs < 1) {
                logger.warn("lock failed. stickMySqlLockBO: {}", SerializableTool.serialize(stickMySqlLockBO));
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.warn("lock failed. stickMySqlLockBO: {}", SerializableTool.serialize(stickMySqlLockBO), e);
            return false;
        }
    }

    @Override
    public Boolean removeLockInfo(String lockObj) {
        if (StringUtils.isBlank(lockObj)) {
            return false;
        }
        try {
            long rs = stickLockDAO.removeLock(lockObj);
            if (rs < 1) {
                logger.warn("unlock failed. lockObj: {}", lockObj);
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.warn("unlock failed. lockObj: {}", lockObj, e);
            return false;
        }
    }

    private boolean isExpire(Date expireTime) {
        if (expireTime == null) {
            return false;
        }
        return new Date().getTime() > expireTime.getTime();
    }
}
