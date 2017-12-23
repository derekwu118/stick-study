package com.derek.stick.lock.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.derek.stick.common.util.CommonUtils;
import com.derek.stick.lock.redis.service.RedisService;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
@Component
public class RedisLock {

    private static final Logger logger              = LoggerFactory.getLogger(RedisLock.class);

    private static final String LOCK_KEY_PREFIX     = "redis-lock:";
    private static final int    MAX_RETRY_TIMES     = 16;

    /**
     * 默认过期时间。单位：s
     */
    private static final int    DEFAULT_EXPIRE_TIME = 60;

    private static final long   SLEEP_TIME          = 50L;

    @Autowired
    private RedisService        redisService;

    /**
     * @param key
     * @param value
     * @param timeout 获取锁的超时时间，单位：ms
     * @return boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    public boolean tryLock(String key, String value, long timeout) {
        if (StringUtils.isBlank(key)) {
            return false;
        }
        String lockKey = generateLockKey(key);
        long startTime = System.currentTimeMillis();
        long timeoutTime = startTime + timeout;
        int retry = 0;
        while (timeoutTime > System.currentTimeMillis() && retry++ < MAX_RETRY_TIMES) {
            logger.info("tryLock key: {}, value: {}, retryTimes: {}", key, value, retry);
            if (redisService.setNX(lockKey, value, DEFAULT_EXPIRE_TIME)) {
                return true;
            }
            CommonUtils.sleep(SLEEP_TIME);
        }
        return false;
    }

    public boolean unlock(String key, String value) {
        if (StringUtils.isBlank(key)) {
            return false;
        }
        String lockKey = generateLockKey(key);
        String val = redisService.get(lockKey);
        if (StringUtils.isBlank(val)) {
            return true;
        }
        if (!val.equals(value)) {
            return false;
        }
        int retry = 0;
        while (retry++ < MAX_RETRY_TIMES) {
            logger.info("unlock key: {}", key);
            if (redisService.delete(lockKey)) {
                return true;
            }
            CommonUtils.sleep(SLEEP_TIME);
        }
        return false;
    }

    private String generateLockKey(String key) {
        return LOCK_KEY_PREFIX + key;
    }
}
