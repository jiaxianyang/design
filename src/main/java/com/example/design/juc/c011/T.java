package com.example.design.juc.c011;

import java.util.concurrent.TimeUnit;

public class T {
    int count = 0;
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + "start");
        while (true) {
            count++;
            try {
                System.out.println(Thread.currentThread().getName() + " count = " + count);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count == 5) {
                    int i = 1/0;
                    System.out.println(i);
                }
            } catch (Exception e) {
                m();
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        },"thread1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        },"thread2").start();
    }
}
