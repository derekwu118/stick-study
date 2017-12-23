package com.derek.stick.lock.zookeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
@Component
public class ZookeeperLock {

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperLock.class);

    public boolean tryLock(String lockObj, long expireTime) {

        return false;
    }

    public boolean unlock() {

        return false;
    }
}
