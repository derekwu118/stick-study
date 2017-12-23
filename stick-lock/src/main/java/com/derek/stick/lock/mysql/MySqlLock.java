package com.derek.stick.lock.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.derek.stick.lock.mysql.service.MySqlLockService;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
@Component
public class MySqlLock {

    @Autowired
    private MySqlLockService mySqlLockService;

}
