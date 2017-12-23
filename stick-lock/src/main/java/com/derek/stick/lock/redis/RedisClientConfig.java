package com.derek.stick.lock.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.derek.stick.lock.redis.service.client.RedisClient;
import com.derek.stick.lock.redis.service.client.SingleRedisClient;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
@Configuration
public class RedisClientConfig {

    @Value("${stick.redis.host}")
    private String  host;
    @Value("${stick.redis.port}")
    private Integer port;
    @Value("${stick.redis.password}")
    private String  password;

    @Bean
    public RedisClient redisClient() {
        // 目前只有单机模式
        if (StringUtils.isBlank(host) || port == null) {
            throw new RuntimeException(String.format("Init RedisClient error. host: %s, port: %s", host, port));
        }
        if (StringUtils.isBlank(password)) {
            return new SingleRedisClient(host, port);
        } else {
            return new SingleRedisClient(host, port, password);
        }
    }
}
