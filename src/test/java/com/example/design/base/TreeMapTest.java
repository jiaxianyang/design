package com.example.design.base;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, Serializable> treeMap = Maps.newTreeMap();

        treeMap.put("af", 2);
        treeMap.put("abc", 1);
        treeMap.put("sf", 3);

        for (int i = 0; i < 100; i++) {
            for (String s : treeMap.keySet()) {
                System.out.println(s);
            }
            System.out.println("======================");
        }
    }
}
