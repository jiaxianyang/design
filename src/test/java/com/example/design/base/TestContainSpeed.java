package com.example.design.base;

import cn.hutool.core.lang.UUID;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestContainSpeed {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result.add(UUID.fastUUID().toString());
        }


        List<String> result2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result2.add(UUID.fastUUID().toString());
        }
        long start = System.currentTimeMillis();
//        Set<String> strings = new HashSet<>(result);
//        result2.forEach(s -> strings.contains(s));
        result2.forEach(s -> result.contains(s));
        System.out.println("耗时：" + (System.currentTimeMillis() -  start) + " millis");
    }

}
