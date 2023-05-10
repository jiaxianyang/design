package com.example.design.base;

import com.example.design.common.entity.Param;
import com.example.design.utils.FileUtils;
import com.example.design.utils.json.JsonUtil;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

public class FileOpreateTest {
    public static void main(String[] args) throws IOException {
        List<String> result = FileUtils.readFile("waitBackShipmentOrderNo.text");
        System.out.println(result.size());
        Lists.partition(result, 500).forEach(subList -> {
            Param param = new Param();
            param.setWarehouseNo("631_165");
            param.setShipmentOrderNoList(subList);
            System.out.println(JsonUtil.toJsonString(param));
            System.out.println("=========================================================");
        });
    }
}
