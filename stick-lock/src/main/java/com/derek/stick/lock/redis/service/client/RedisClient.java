package com.derek.stick.lock.redis.service.client;

import redis.clients.jedis.Jedis;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
public abstract class RedisClient {

    public abstract Jedis getJedis();

    public abstract void close();
}
