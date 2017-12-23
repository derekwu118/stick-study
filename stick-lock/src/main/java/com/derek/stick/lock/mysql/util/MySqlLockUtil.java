package com.derek.stick.lock.mysql.util;

import com.derek.stick.lock.mysql.entity.StickLockDO;
import com.derek.stick.lock.mysql.entity.StickMySqlLockBO;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
public class MySqlLockUtil {

    public static StickLockDO transform2StickLockDO(StickMySqlLockBO src) {
        if (src == null) {
            return null;
        }
        StickLockDO target = new StickLockDO();
        target.setLockObj(src.getLockObj());
        target.setExpireDuration(src.getExpireDuration());
        target.setExpireTime(src.getExpireTime());
        return target;
    }

    public static StickMySqlLockBO transform2StickLockBO(StickLockDO src) {
        if (src == null) {
            return null;
        }
        StickMySqlLockBO target = new StickMySqlLockBO();
        target.setLockObj(src.getLockObj());
        target.setExpireDuration(src.getExpireDuration());
        target.setExpireTime(src.getExpireTime());
        return target;
    }
}
