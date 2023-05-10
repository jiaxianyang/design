package com.example.design.base;

import com.example.design.utils.json.JsonUtil;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
@ExtendWith(MockitoExtension.class)
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ok", "1111");
        hashMap.put(null, null);
        System.out.println(hashMap);

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

    @Test
    void testMerge() {
        HashMap<String, String> specialPrice = new HashMap<>();
        specialPrice.put("1", "1");
        specialPrice.put("2", "2");
        specialPrice.put("3", "3");
        HashMap<String, String> collect = new HashMap<>();
        collect.put("4", "4");
        collect.put("3", "5");
        collect.put("6", "6");
        collect.forEach((k, v) -> specialPrice.merge(k, v, (v1, v2) -> v1));
        System.out.println("specialPrice" + JsonUtil.toJsonString(specialPrice));
        System.out.println("collect" + JsonUtil.toJsonString(collect));
    }
}
