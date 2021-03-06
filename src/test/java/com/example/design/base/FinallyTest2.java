package com.example.design.base;

public class FinallyTest2 {

    public static void main(String[] args) {
        System.out.println(test2());
    }

    /**
     *  这说明finally里的return直接返回了，就不管try中是否还有返回语句，这里还有个小细节需要注意，finally里加上return过后，finally外面的return b就变成不可到达语句了，也就是永远不能被执行到，所以需要注释掉否则编译器报错。
     * @return
     */
    private static int test2() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
            return 200;
        }
//        return b;
    }
}
