package com.derek.stick.test;

/**
 * Java finally执行顺序的思考
 *
 * https://www.yfzzweb.com/%E9%9D%A2%E8%AF%95%E9%A2%98/java-try-catch-finally/?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 *
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
public class TestFinallyMain {

    static String s = "A";

    public static void main(String[] args) {
        // case 1
        println("case 1: ");
        test1();
        // case 2
        println("\ncase 2: ");
        test2();
        // case 3
        println("\ncase 3: ");
        test3();
        // case 4
        println("\ncase 4: ");
        test4();
    }

    private static void println(String s) {
        System.out.println(s);
    }

    private static void println(int x) {
        System.out.println(x);
    }

    private static void test1() {
        // ABAB
        println(test1Fun());
        println(s);
    }

    private static String test1Fun() {
        try {
            println("A");
            return s = "A";
        } finally {
            println("B");
            s = "B";
        }
    }

    private static void test2() {
        println(test2Fun());
    }

    private static int test2Fun() {
        int b = 20;
        try {
            println("try block");
            return b += 80;
        } catch (Exception e) {
            println("catch block");
        } finally {
            println("finally block");
            if (b > 25) {
                println("b>25, b = " + b);
            }
        }
        return b;
    }

    private static void test3() {
        println(test3Fun1());
    }

    private static String test3Fun1() {
        try {
            println("try block");
            return test3Fun2();
        } finally {
            println("finally block");
        }
    }

    private static String test3Fun2() {
        println("return statement");
        return "after return";
    }

    private static void test4() {
        println(test4Fun());
    }

    private static int test4Fun() {
        int b = 20;
        try {
            println("try block");
            return b += 80;
        } catch (Exception e) {
            println("catch block");
        } finally {
            println("finally block");
            if (b > 25) {
                println("b>25, b = " + b);
            }
            b = 10;
        }
        return b;
    }
}
