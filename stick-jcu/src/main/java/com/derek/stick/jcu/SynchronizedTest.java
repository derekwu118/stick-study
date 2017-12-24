package com.derek.stick.jcu;

/**
 * @author derek.wu
 * @date 2017-12-24
 * @since v1.0.0
 */
public class SynchronizedTest {

    public synchronized void test1() {

    }

    public void test2() {
        synchronized (this) {

        }
    }

}
