package com.derek.stick.lock.redis.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derek.stick.lock.redis.service.RedisService;
import com.derek.stick.lock.redis.service.client.RedisClient;

import redis.clients.jedis.Jedis;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
@Service
public class RedisServiceImpl implements RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private RedisClient         redisClient;

    @Override
    public Boolean setNX(String key, String value, Integer expireTime) {
        Jedis jedis = redisClient.getJedis();
        if (jedis.setnx(key, value) == 1) {
            jedis.expire(key, expireTime);
            return true;
        }
        return false;
    }

    @Override
    public String get(String key) {
        return redisClient.getJedis().get(key);
    }

    @Override
    public Boolean delete(String key) {
        return redisClient.getJedis().del(key) == 1;
    }

}
