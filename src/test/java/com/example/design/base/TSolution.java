package com.example.design.base;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TSolution {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1
                , 2
                , 1
                , TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(2)
                , new ThreadFactoryBuilder().setNameFormat("jia-%s").build()
                , new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    Thread.sleep(1000);
                    System.out.println("正在执行任务===============");
                }
            });
        }
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(1 / 0);
            }
        });




        while (true) {
            Thread.sleep(1000);
        }
    }
}
