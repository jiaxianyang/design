package com.example.design.base;

import com.example.design.utils.json.JsonUtil;
import com.google.common.base.Stopwatch;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.example.design.base.HttpRequestMock.getMouBaoDiscounts;

public class TestCompletable {
    public static void main(String[] args) throws IOException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
                System.out.println("");
                return UUID.randomUUID().toString();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return UUID.randomUUID().toString();
        });

        future.whenComplete((uuid, exception) -> {
            System.out.println(uuid);
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(1111);
        System.in.read();
    }

    @Test
    void test1() throws Exception{
        Stopwatch started = Stopwatch.createStarted();
        List<String> products = Lists.newArrayList("sku1", "sku2", "sku3", "sku4");
        // 先触发各自平台的并行处理
        List<CompletableFuture<PriceResult>> completableFutures = products.stream()
                .map(product -> CompletableFuture.supplyAsync(() -> HttpRequestMock.getMouBaoPrice(product))
                        .thenCombine(CompletableFuture.supplyAsync(() -> getMouBaoDiscounts(product)), this::computeRealPrice))
                .collect(Collectors.toList());

        // 在独立的流中，等待所有并行处理结束，做最终结果处理
        PriceResult priceResult = completableFutures.stream()
                .map(CompletableFuture::join)
                .sorted(Comparator.comparingInt(PriceResult::getRealPrice))
                .findFirst()
                .get();
        System.out.println(JsonUtil.toJsonString(priceResult));
        Stopwatch stop = started.stop();
        System.out.println("elapsed: " + started.elapsed(TimeUnit.MILLISECONDS));
    }

    private PriceResult computeRealPrice(PriceResult price, PriceResult discountPrice) {
        return PriceResult.builder().realPrice(price.getPrice() - discountPrice.getDiscountPrice()).build();
    }
}
