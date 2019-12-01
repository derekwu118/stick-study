package com.derek.stick.sample.oom;

/**
 * @author derek.wu
 * @date 2019-11-07
 * @since v1.0.0
 */
public class JavaVMStackOOM {

    public static void main(String[] args){
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

    private void dontStop() {
        while (true) {
        }
    }

    void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
}
