package com.derek.stick.dproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author derek.wu
 * @date 2019-11-07
 * @since v1.0.0
 */
public class SampleClass {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
                throws Throwable {
                System.out.println("before...");
                Object res = methodProxy.invokeSuper(obj, args);
                System.out.println("after...");
                return res;
            }
        });
        SampleClass sampleClass = (SampleClass) enhancer.create();
        Long res = sampleClass.doSth();
        System.out.println("Main.res: " + res);
    }

    public Long doSth() {
        long rs = System.currentTimeMillis();
        System.out.println(String.format("SampleClass doSth() => %d.", rs));
        return rs;
    }
}
