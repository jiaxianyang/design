package com.example.design.singleton;

/**
 * Mgr01简介
 *
 * 饿汉模式：
 *      类加载到内存中就实例化一个单例，JVM保证线程安全，简单实用，推荐使用
 *      缺点：不管用到与否，类装载完就实例化
 * @author jiaxianyang
 * @date 2021-05-15 11:43
 */
public class Mgr01 {

    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {
    }

    public static Mgr01 getInstance() {return INSTANCE;}

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 instance1 = Mgr01.getInstance();
        Mgr01 instance2 = Mgr01.getInstance();
        System.out.println(instance1 == instance2);
    }
}
