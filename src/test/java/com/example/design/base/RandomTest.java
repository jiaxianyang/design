package com.example.design.base;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RandomTest {


    public static void main(String[] args) {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 100, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000), new ThreadFactoryBuilder().setNameFormat("test-%s").build()
                , new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 100; i++) {
            int workId = i;
            threadPoolExecutor.submit(()-> {
                SnowflakeSequenceGen snowflakeSequenceGen = new SnowflakeSequenceGen(workId, 1);
                while (true) {
                    snowflakeSequenceGen.gen();
                }
            });
        }
        while (true);
    }
}
