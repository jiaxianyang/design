package com.example.design.utils;

import com.example.design.utils.json.JsonUtil;
import com.example.design.utils.json.TypeReference;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 临时测试
 *
 * @author jiaxianyang
 * @date 2024/7/31 14:03
 */
public class TempTest {
    public static void main(String[] args) throws InterruptedException {


        System.out.println("字符串比较 " + "1".equals('1'));
        Map<String, Object> map = Maps.newHashMap();
        map.put("k1", new Date());
        map.put("k2", "a");
        map.put("k3", Boolean.TRUE);
        map.put("k4", 1);
        map.put("k5", new BigDecimal("1.0"));
        Map<String, Object> subMap = Maps.newHashMap();
        subMap.put("k7", "7");
        map.put("k6", subMap);

        String jsonString = JsonUtil.toJsonString(map);
        Map<String, Object> map2 = JsonUtil.parseObject(jsonString, Map.class);

        Map<String, Object> map3  = JsonUtil.parseObject(jsonString, new TypeReference<Map<String, Object>>() {
        });
        Map<String, Object> newHashMap = new HashMap<>(map);
        Stopwatch started = Stopwatch.createStarted();
//        for (int i = 0; i < 1000000; i++) {
//            Map<String, Object> map4 = (Map<String, Object>) SerializationUtils.clone((Serializable) map);
//            Map<String, Object> map5 = (Map<String, Object>) SerializationUtils.clone((Serializable) map);
//        }
        System.out.println(started.elapsed(TimeUnit.MILLISECONDS));

        Thread.sleep(1000);
        map2.put("k1", new Date());
        map3.put("k3", Boolean.FALSE);
        newHashMap.put("k10", Boolean.TRUE);
        newHashMap.put("k1", new Date());


        System.out.println(JsonUtil.toJsonString(map));
        System.out.println(JsonUtil.toJsonString(map2));
        System.out.println(JsonUtil.toJsonString(map3));
        System.out.println(JsonUtil.toJsonString(newHashMap));
    }
}
