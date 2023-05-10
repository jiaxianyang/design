package com.example.design.common.entity;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class BatchRule {
    /**
     * 集合单互斥规则
     */
    private List<Token> batchTokens;

    public static void main(String[] args) {
//        BatchRule batchRule = new BatchRule();
//        PropertyKeyIncludeValueExcludeToken propertyKeyIncludeValueExcludeToken = new PropertyKeyIncludeValueExcludeToken();
//        Map<Object, Object> map = Maps.newHashMap();
//        map.put("2", "2");
//        map.put(null, " 1");
//        propertyKeyIncludeValueExcludeToken.setMap(map);
//        batchRule.setBatchTokens(Lists.newArrayList(propertyKeyIncludeValueExcludeToken));
//        JsonUtil.toJsonString(batchRule);
//        System.out.println(JSON.toJSONString(batchRule));
//        JsonUtil.parseObject(JSON.toJSONString(batchRule), BatchRule.class);
//        System.out.println(batchRule.toString());
//        System.out.println(map.remove(null));

        List<Integer> integers = Lists.newArrayList();
        integers.add(6);
        integers.add(7);
        integers.add(2);
        integers.add(1);
        integers.add(5);
        integers.add(3);
        integers.add(4);
        Collections.sort(integers);

        BigDecimal divide = BigDecimal.ONE.divide(new BigDecimal("2"), 0, RoundingMode.DOWN);
        System.out.println(divide);
    }

}