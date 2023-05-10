package com.example.design.base;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
@Slf4j
public class EhcacheTest {

    private static final String ORDER_CACHE = "orderCache";
    public static void main(String[] args) {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                // 创建cache实例
                .withCache(ORDER_CACHE, CacheConfigurationBuilder
                        // 声明一个容量为20的堆内缓存
                        .newCacheConfigurationBuilder(String.class, String.class, ResourcePoolsBuilder.heap(20)))
                .build(true);
        // 获取cache实例
        Cache<String, String> cache = cacheManager.getCache(ORDER_CACHE, String.class, String.class);

        String orderId = String.valueOf(123456789);
        String orderInfo = cache.get(orderId);
        if (StrUtil.isBlank(orderInfo)) {
            orderInfo = getInfo(orderId);
            cache.put(orderId, orderInfo);
        }
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
