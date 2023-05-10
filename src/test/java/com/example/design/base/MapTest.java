package com.example.design.base;

import com.example.design.common.entity.Order;
import com.example.design.common.entity.ShipmentOrderAttributeDto;
import com.example.design.common.entity.User;
import com.example.design.utils.json.JsonUtil;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.assertj.core.util.Lists;
import org.springframework.cglib.beans.BeanMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MapTest {

    public static void main(String[] args) {
        ShipmentOrderAttributeDto shipmentOrderAttributeDto = new ShipmentOrderAttributeDto();
        shipmentOrderAttributeDto.setScheduleBillSort(2);
        shipmentOrderAttributeDto.setBusinessSubType("99");
        BeanMap beanMap = BeanMap.create(shipmentOrderAttributeDto);
        beanMap.put("test", "test");
        Map<String, String> realMap = Maps.newHashMap();
        realMap.putAll(beanMap);
        realMap.put("98","98");
        System.out.println(realMap);
        beanMap.forEach((k, v) -> {
            if (Objects.nonNull(v) && !realMap.containsKey(k)) {
                realMap.put(String.valueOf(k), String.valueOf(v));
            }
        });

        beanMap.putAll(realMap);

//        System.out.println(BeanMap.create(null));


        Order order = new Order();
        Order order2 = new Order();
        ArrayList<Order> orders = Lists.newArrayList(order, order2);
        Map<Integer, List<Order>> collect = orders.stream().collect(Collectors.groupingBy(Order::getStatus));
        System.out.println(collect);

        Integer ok = MapUtils.getInteger(null, "ok");
        Integer ok1 = MapUtils.getInteger(Maps.newHashMap(), "ok");
        System.out.println(Integer.valueOf(1).equals(ok));
        System.out.println(ok);
        System.out.println(ok1);

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("a", "1");
        System.out.println(JsonUtil.toJsonString(concurrentHashMap));


        Map<String, Object> map = Maps.newHashMap();
        Object a = map.remove("a");


        System.out.println(a);

        Map<String, String> map1 = Maps.newHashMap();
        map1.put("name", "jxy");
        User user = mapToShipmentOrderAttribute(map1, new User());
        System.out.println(JsonUtil.toJsonString(user));
    }



    /**
     * 将map装换为javabean对象
     *
     * @param map  HashMap
     * @param bean javaBean
     * @return javaBean
     */
    public static <T> T mapToShipmentOrderAttribute(Map<String, String> map, T bean) {
        if (MapUtils.isEmpty(map)) {
            return null;
        }
        Map<String, Object> convertMap = new HashMap<>();
        convertMap.putAll(map);
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(convertMap);
        return bean;
    }
}
