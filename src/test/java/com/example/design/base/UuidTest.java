package com.example.design.base;

import com.example.design.utils.UuidUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ExtendWith(MockitoExtension.class)
public class UuidTest {

    public static ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 5, 30, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(5000000), new ThreadFactoryBuilder().setNameFormat("testUuid-%s").build()
            , new ThreadPoolExecutor.DiscardPolicy());

    public static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>(10000000);

    public static void main(String[] args) throws InterruptedException {
        System.out.println(UuidUtil.getUuid());
        System.out.println("=============start==================");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int finalI = i;
            executorService.submit(() -> {
                testUUid(finalI);
            });
            if (i % 5000000 == 0) Thread.sleep(10);
        }
        System.out.println("=============end==================");
        while (true) {

        }
    }

    private static void testUUid(int i) {
        if (concurrentHashMap.contains(UuidUtil.getUuid())) {
            throw new RuntimeException("uuid has eaquls");
        }
        concurrentHashMap.put(UuidUtil.getUuid(), 1);
        if (i % 1000 == 0) {
            System.out.println("进行中======================: " + i);
        }
        if (concurrentHashMap.size() > 10000000) {
            concurrentHashMap.clear();
        }
    }

    @Test
    @DisplayName("生成uuid")
    void generateUUid() {
        System.out.println(UUID.randomUUID());
    }
}
