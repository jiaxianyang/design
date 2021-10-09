package com.example.design.base;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, Serializable> linkedHashMap = Maps.newLinkedHashMap();

        linkedHashMap.put("abc", 1);
        linkedHashMap.put("sf", 3);
        linkedHashMap.put("af", 2);

        for (int i = 0; i < 100; i++) {
            for (String s : linkedHashMap.keySet()) {
                System.out.println(s);
            }
            System.out.println("======================");
        }
    }
}
