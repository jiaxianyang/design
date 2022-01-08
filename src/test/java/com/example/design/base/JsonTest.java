package com.example.design.base;

import com.example.design.common.entity.OrderNotificationDto;
import com.example.design.utils.json.JsonUtil;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JsonTest {
    public static final ThreadPoolExecutor executorService = new ThreadPoolExecutor(50, 50, 30, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100000), new ThreadFactoryBuilder().setNameFormat("test-%s").build()
            , new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) {
        String bigJsonStr = buildBigJson();

        while (true) {
            int size = executorService.getQueue().size();
            if (size < 80000) {
                executorService.execute(() -> {
                    Stopwatch started = Stopwatch.createStarted();
                    for (int i = 0; i < 600; i++) {
                        OrderNotificationDto notificationDto = JsonUtil.parseObject(bigJsonStr, OrderNotificationDto.class);
                        JsonUtil.toJsonString(notificationDto);
                    }
                    System.out.printf("===============烤机进行中====================== now: %s , threadName: %s, elapsed: %s%n", LocalDateTime.now().toString(), Thread.currentThread().getName(), started.elapsed(TimeUnit.MILLISECONDS));
                });
            }
        }
    }

    public static String buildBigJson() {
        String jsonStr = "{\"orderNodeMsgEnum\":\"PICKED\",\"tenantCode\":\"WMS_NG\",\"shipmentOrderNo\":\"SO-6_6_605-1475652257306382336\",\"orderNo\":\"1261658866305\",\"warehouseNo\":\"6_6_605\",\"businessId\":\"1261658866305_40\",\"orderType\":46,\"orderSource\":\"1\",\"shipmentOrderType\":\"OB-L01\",\"sendPay\":\"\",\"ownerNo\":\"2\",\"carrierNo\":\"\",\"scheduleBillCode\":\"\",\"deliveryDestination\":0,\"recipientNo\":\"\",\"shipperNo\":\"\",\"flowNo\":\"\",\"routeNo\":\"\",\"orderSubType\":0,\"currentStatus\":40,\"operator\":\"duankaiyuan\",\"operateTime\":\"2021-12-28 10:32:32\"}";
        OrderNotificationDto orderNotificationDto = JsonUtil.parseObject(jsonStr, OrderNotificationDto.class);
        for (int i = 0; i < 1000; i++) {
            OrderNotificationDto notificationDto = new OrderNotificationDto();
            BeanUtils.copyProperties(orderNotificationDto, notificationDto);
            orderNotificationDto.setChildren(notificationDto);
        }
        return JsonUtil.toJsonString(orderNotificationDto);
    }
}
