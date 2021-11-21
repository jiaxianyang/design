package com.example.design.interview;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.Semaphore;

/**
 * CirclePrint简介
 *
 * 三个线程循环打印
 * @author jiaxianyang
 * @date 2021-11-16 11:14
 */
public class CirclePrint {

    static class ThreadDemo extends Thread {

        private Semaphore current;
        private Semaphore next;
        private String name;

        /**
         * 构造方法
         * @param current 要获取的当前锁
         * @param next  要释放的下一把锁
         * @param name  打印内容
         */
        public ThreadDemo(Semaphore current, Semaphore next, String name) {
            this.current = current;
            this.next = next;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                //获取当前锁，然后打印
                try {
                    current.acquire();
                    System.out.print(name +" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //释放下一把锁
                next.release();
            }
        }
    }

    public static void main(String[] args) {
        //初始化三把锁， 只有A锁是可用的
        Semaphore A = new Semaphore(1);
        Semaphore B = new Semaphore(0);
        Semaphore C = new Semaphore(0);

        //创建并启动三个线程，线程1获取A锁，释放B锁
        new ThreadDemo(A, B, "A").start();
        new ThreadDemo(B, C, "B").start();
        new ThreadDemo(C, A, "C").start();
    }

}
