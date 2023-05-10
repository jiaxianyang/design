package com.example.design.base;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.base.Stopwatch;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
@Slf4j
public class CacheTest {

    public static void main(String[] args) throws ExecutionException {
        Stopwatch started = Stopwatch.createStarted();
        for (int i = 0; i < 10000000; i++) {
            caffeineCache.get("ESL8907654321");
        }
        System.out.println(started.stop().elapsed(TimeUnit.MILLISECONDS));
    }

    public static LoadingCache<String, String> guavaCache = CacheBuilder.newBuilder()
            .initialCapacity(5)  // 初始容量
            .maximumSize(10)     // 最大缓存数，超出淘汰
            .expireAfterWrite(60, TimeUnit.SECONDS)// 过期时间
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return getInfo(key);
                }
            });


    public static com.github.benmanes.caffeine.cache.LoadingCache<String, String> caffeineCache = Caffeine.newBuilder()
            .initialCapacity(5)
            // 超出时淘汰
            .maximumSize(10)
            //设置写缓存后n秒钟过期
            .expireAfterWrite(60, TimeUnit.SECONDS)
            //设置读写缓存后n秒钟过期,实际很少用到,类似于expireAfterWrite
            //.expireAfterAccess(17, TimeUnit.SECONDS)
            .build(new com.github.benmanes.caffeine.cache.CacheLoader<String, String>() {
                @Override
                public @Nullable String load(@NonNull String s) throws Exception {
                    return getInfo(s);
                }
            });


    private static String getInfo(String orderId) {
        String info = "";
        // 先查询redis缓存
        log.info("get data from redis");

        // 当redis缓存不存在查db
        log.info("get data from mysql");
        info = String.format("{orderId=%s}", orderId);
        return info;
    }
}
