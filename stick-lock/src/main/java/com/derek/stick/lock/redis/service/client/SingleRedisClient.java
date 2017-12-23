package com.derek.stick.lock.redis.service.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
public class SingleRedisClient extends RedisClient {

    private static final int DEFAULT_TIMEOUT = 3000;

    private JedisPool        jedisPool;

    public SingleRedisClient(String host, int port) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setMaxTotal(10);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(false);
        jedisPool = new JedisPool(config, host, port, DEFAULT_TIMEOUT);
    }

    public SingleRedisClient(String host, int port, String password) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setMaxTotal(10);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(false);
        jedisPool = new JedisPool(config, host, port, DEFAULT_TIMEOUT, password);
    }

    @Override
    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    @Override
    public void close() {
        if (jedisPool != null) {
            jedisPool.close();
            jedisPool.destroy();
        }
    }
}
