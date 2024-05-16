package com.example.design.base;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("ok", "1111");
//        hashMap.put(null, null);
        System.out.println(hashMap);

        System.out.println("containsKey is null : " +  hashMap.containsKey(null));
        System.out.println("containsKey is null : " +  hashMap.containsKey(MapUtils.getString(hashMap,"ok")));
        System.out.println("containsValue is null : " +  String.valueOf(hashMap.get("ok0000")));

        System.out.println("===================================");


        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 100000000; i++) {
            Map<String, Serializable> hashMapSorted = Maps.newHashMap();

            hashMapSorted.put("af", 2);
            hashMapSorted.put("abc", 3);
            hashMapSorted.put("jfds", 3);
            hashMapSorted.put("fafda", 3);
            hashMapSorted.put("sfaa", 3);
            hashMapSorted.put("safdasff", 3);
            hashMapSorted.put("assdfadsf", 3);
            hashMapSorted.put("ccsa", 3);
            hashMapSorted.put("ba", 3);
            StringBuilder sb = new StringBuilder();
            for (String s : hashMapSorted.keySet()) {
                sb.append(s).append("-");
            }
            set.add(sb.toString());
        }
        System.out.println("======================");
        System.out.println(set.size());
    }
}
