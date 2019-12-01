package com.derek.stick.sample.oom;

/**
 *
 * @author derek.wu
 * @date 2019-11-07
 * @since v1.0.0
 */
public class JavaVMStackSOF {

    private int stackLen = 1;

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack len: " + javaVMStackSOF.stackLen);
            throw e;
        }
    }

    void stackLeak() {
        stackLen++;
        stackLeak();
    }
}
