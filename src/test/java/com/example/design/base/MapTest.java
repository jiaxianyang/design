package com.example.design.base;

import com.example.design.common.entity.ShipmentOrderAttributeDto;
import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanMap;

import java.util.Map;
import java.util.Objects;

public class MapTest {

    public static void main(String[] args) {
        ShipmentOrderAttributeDto shipmentOrderAttributeDto = new ShipmentOrderAttributeDto();
        shipmentOrderAttributeDto.setScheduleBillSort(2);
        shipmentOrderAttributeDto.setBusinessSubType("99");
        BeanMap beanMap = BeanMap.create(shipmentOrderAttributeDto);
        beanMap.put("test", "test");
        Map<String, String> realMap = Maps.newHashMap();
//        realMap.putAll(beanMap);
//        realMap.put("98","98");
//        System.out.println(realMap);
        beanMap.forEach((k, v) -> {
            if (Objects.nonNull(v) && !realMap.containsKey(k)) {
                realMap.put(String.valueOf(k), String.valueOf(v));
            }
        });

        System.out.println(BeanMap.create(null));
    }
}
