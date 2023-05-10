package com.example.design.base;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class HttpRequestMock {
    private static Map<String, Integer> priceMap = Maps.newHashMap();
    static {
        priceMap.put("sku1_MouBaoPrice", 100);
        priceMap.put("sku2_MouBaoPrice", 1000);
        priceMap.put("sku3_MouBaoPrice", 10000);
        priceMap.put("sku4_MouBaoPrice", 100000);
        priceMap.put("sku1_MouBaoDiscounts", 10);
        priceMap.put("sku2_MouBaoDiscounts", 100);
        priceMap.put("sku3_MouBaoDiscounts", 1000);
        priceMap.put("sku4_MouBaoDiscounts", 10000);
    }

    public static PriceResult getMouBaoPrice(String product) {
        CompletableFuture<Integer> future = getIntegerCompletableFuture(product+"_MouBaoPrice");

        try {
            return PriceResult.builder().price(future.get()).build();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static CompletableFuture<Integer> getIntegerCompletableFuture(String key) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("");
                return priceMap.get(key);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return priceMap.get(key);
        });
        return future;
    }

    public static PriceResult getMouBaoDiscounts(String product) {
        CompletableFuture<Integer> future = getIntegerCompletableFuture(product+"_MouBaoDiscounts");

        try {
            return PriceResult.builder().discountPrice(future.get()).build();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
