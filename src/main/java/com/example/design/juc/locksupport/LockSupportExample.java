package com.example.design.juc.locksupport;

import lombok.SneakyThrows;

import java.util.concurrent.locks.LockSupport;

/**
 * @author jiaxianyang
 * @date 2024/6/5 12:06
 */
public class LockSupportExample {
    private static volatile Thread owner;

    public static void main(String[] args) {
//        parkAndUnPark();
        LockSupportExample lockSupportExample = new LockSupportExample();
        Thread owner = Thread.currentThread();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lockSupportExample.unlock(owner);
        }).start();

        lockSupportExample.lock();
    }

    private static void parkAndUnPark() {
        Object blocker = new Object();

        Thread thread = new Thread(() -> {
            System.out.println("Thread will park with blocker.");
            LockSupport.park(blocker);
            System.out.println("Thread is unparked.");
        });

        thread.start();

        try {
            Thread.sleep(5000); // 确保线程已经启动并挂起
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread will unpark the thread.");
        LockSupport.unpark(thread);
    }

    public  void lock() {
        Thread current = Thread.currentThread();
        if (owner != current) {
            System.out.println("park 了");
            owner = current;
            LockSupport.park(this);
            System.out.println("park 后可以执行 了");
        }
    }

    public void unlock(Thread thread) {
        if (thread == owner) {
            System.out.println("un park 了");
            LockSupport.unpark(thread);
            owner = null;
        }
    }
}
