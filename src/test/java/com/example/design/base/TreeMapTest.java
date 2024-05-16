package com.example.design.base;

import com.example.design.common.entity.OrderDetailVo;
import com.example.design.common.entity.ShipmentOrderAttributeDto;
import com.example.design.utils.json.JsonUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
@ExtendWith(MockitoExtension.class)
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


        TreeMap<String, BigDecimal> treeMapSkuQty = new TreeMap<>();
        OrderDetailVo orderDetailVo1 = new OrderDetailVo("af", BigDecimal.valueOf(2));
        OrderDetailVo orderDetailVo2 = new OrderDetailVo("abc", BigDecimal.valueOf(1));
        OrderDetailVo orderDetailVo3 = new OrderDetailVo("sf", BigDecimal.valueOf(3));
        OrderDetailVo orderDetailVo4 = new OrderDetailVo("abc", BigDecimal.valueOf(10));
        List<OrderDetailVo> orderDetailVoList = Lists.newArrayList(orderDetailVo1, orderDetailVo2, orderDetailVo3,orderDetailVo4);
        Map<String, String> result = new HashMap<>();
        orderConstructNameCalculate(result, orderDetailVoList);
        System.out.println(JsonUtil.toJsonString(result));

//        abc*11_af*2_sf*3
    }



    public static void orderConstructNameCalculate(Map<String, String> externalInfo, List<OrderDetailVo> orderDetailVoList) {
        if (CollectionUtils.isNotEmpty(orderDetailVoList)) {
            TreeMap<String, BigDecimal> treeMap = new TreeMap<>();
            orderDetailVoList.forEach( d -> {
                if (treeMap.containsKey(d.getSku())) {
                    treeMap.put(d.getSku(), treeMap.get(d.getSku()).add(d.getQty()));
                } else {
                    treeMap.put(d.getSku(), d.getQty());
                }
            });
            if (MapUtils.isNotEmpty(treeMap)) {
                String orderConstructName = treeMap.entrySet().stream().map(e -> {
                    return e.getKey() + "*" + String.valueOf(e.getValue());
                }).collect(Collectors.joining("_"));
                externalInfo.put("orderConstructName", orderConstructName);
            }
        }
    }


    public static List<String> parseSKUListFromOrderConstructName(String orderConstructName) {
        // 使用"_"分割字符串以获取每个SKU和数量的组合
        String[] parts = orderConstructName.split("_");
        List<String> skus = new ArrayList<>(parts.length);

        for (String part : parts) {
            // 对于每个SKU和数量的组合，进一步使用"*"分割以提取SKU
            String[] skuPair = part.split("\\*");
            skus.add(skuPair[0]); // 将SKU添加到列表中
        }
        return skus;
    }

    @Test
    void testSplitOrderConstructName() {
        List<String> skus = parseSKUListFromOrderConstructName("EMG1899774797*1.0_EMG20230808505*1.0_EMG20230808806*1.0_EMG202309120002*1.0_EMG20231019001*1.0_EMG20240226002*1.0_EMG2312290001*1.0_EMG2312290006*1.0_EMG2401030004*1.0_EMG4398060906589*1.0");
        System.out.println(JsonUtil.toJsonString(skus));
    }
}
