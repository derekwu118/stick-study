package com.derek.stick.dproxy.jdk;

/**
 * @author derek.wu
 * @date 2019-11-07
 * @since v1.0.0
 */
public class Main {

    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = new JdkDynamicProxy(new SubjectImpl()).getProxy();
        Long res = subject.doSth();
        System.out.println("Main.res: " + res);
    }
}
