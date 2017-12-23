package com.derek.stick.lock.redis.service;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
public interface RedisService {

    /**
     * 
     * @param key
     * @param value
     * @param expireTime 过期时间，单位：s
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-23
     * </PRE>
     */
    Boolean setNX(String key, String value, Integer expireTime);

    String get(String key);

    Boolean delete(String key);
}
