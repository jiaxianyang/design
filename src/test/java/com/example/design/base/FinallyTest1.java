package com.example.design.base;

/**
 * FinallyTest1简介
 *
 *  说明了发生异常后，catch中的return语句先执行，确定了返回值后再去执行finally块，
 *  执行完了catch再返回，finally里对b的改变对返回值无影响，原因同前面一样，也就是说情况与try中的return语句执行完全一样。
 *
 * @author jiaxianyang
 * @date 2021-04-25 14:23
 */
public class FinallyTest1 {
    public static void main(String[] args) {
        System.out.println(test11());
    }

    /**
     *  说明try中的return语句先执行了但并没有立即返回，等到finally执行结束后再
     * @return
     */
    private static String test11() {
        try {
            System.out.println("try block");
            return test12();
        } finally {
            System.out.println("finally block");
        }
    }

    private static String test12() {
        System.out.println("return statement");
        return "after return";
    }

    /**
     * 通过下面方法的例子：
     *      说明return 语句已经执行了，再去执行finally语句，不过没有直接返回，而是等finally执行完之后再返回
     *
     * @return
     */
    private static int test1() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b > 25, b = " + b);
            }
        }
        return b;
    }
}
