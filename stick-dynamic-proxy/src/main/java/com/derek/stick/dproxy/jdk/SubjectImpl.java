package com.derek.stick.dproxy.jdk;

/**
 * @author derek.wu
 * @date 2019-11-07
 * @since v1.0.0
 */
public class SubjectImpl implements Subject {

    @Override
    public Long doSth() {
        long rs = System.currentTimeMillis();
        System.out.println(String.format("Subject Impl doSth() => %d.", rs));
        return rs;
    }
}
