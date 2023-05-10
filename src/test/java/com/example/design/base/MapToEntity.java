package com.example.design.base;

import com.example.design.utils.json.JsonUtil;

import java.util.HashMap;
import java.util.Map;

public class MapToEntity {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "jia");

        System.out.println(JsonUtil.toJsonString(hashMap));
    }
}
