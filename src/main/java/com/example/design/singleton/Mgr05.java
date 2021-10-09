package com.example.design.singleton;

import java.util.Random;

public class Mgr05 {

    private static Mgr05 INSTANCE;

    private Mgr05() {
    }

    //锁粒度太大了，只要访问方法就会上锁
    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Mgr05.class) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr05.getInstance().hashCode())).start();
        }
        while (true){}
    }
}
