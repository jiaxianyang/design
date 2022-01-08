package com.example.design.base;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadLocalTest {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                System.out.println(MessageFormat.format("当前线程名称: {0},线程id:{1}", Thread.currentThread().getName(), threadId.get()));
            } finally {
                //线程使用完后一定要释放
                threadId.remove();
            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(100);

        new Thread(() -> {
            try {
                System.out.println(MessageFormat.format("当前线程名称: {0},线程id:{1}", Thread.currentThread().getName(), threadId.get()));
            } finally {
                //线程使用完后一定要释放
                threadId.remove();
            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(100);

        new Thread(() -> {
            try {
                System.out.println(MessageFormat.format("当前线程名称: {0},线程id:{1}", Thread.currentThread().getName(), threadId.get()));
            } finally {
                //线程使用完后一定要释放
                threadId.remove();
            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(100);
    }


    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "oldThreadLocal");

    @Test
    void test() throws InterruptedException {
        System.out.println("获取初始值： " + threadLocal.get());
        threadLocal.set("newThreadlocal");
        System.out.println("获取修改后的值：" + threadLocal.get());
        threadLocal.remove();
    }

}
