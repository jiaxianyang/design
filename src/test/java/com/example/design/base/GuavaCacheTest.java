package com.example.design.base;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
@Slf4j
public class GuavaCacheTest {

    public static void main(String[] args) throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .initialCapacity(5)  // 初始容量
                .maximumSize(10)     // 最大缓存数，超出淘汰
                .expireAfterWrite(60, TimeUnit.SECONDS)// 过期时间
                .build();

        String orderId = String.valueOf(123456789);
        // 获取orderInfo，如果key不存在，callable中调用getInfo方法返回数据
        String orderInfo = cache.get(orderId, () -> getInfo(orderId));
        log.info("orderInfo = {}", orderInfo);

    }

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
