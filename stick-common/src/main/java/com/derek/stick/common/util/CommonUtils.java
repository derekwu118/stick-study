package com.derek.stick.common.util;

/**
 * @author derek.wu
 * @date 2017-12-23
 * @since v1.0.0
 */
public class CommonUtils {

    public static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("sleep occur error. mills: %s", mills), e);
        }
    }
}
