package com.example.design.base;

import com.example.design.common.entity.Order;
import com.example.design.utils.json.JsonUtil;
import com.google.common.collect.Lists;
import org.assertj.core.util.Sets;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListSortTest {

    public static void main(String[] args) {
        LocalDateTime minusDays1 = LocalDateTime.now().minusDays(1);
        LocalDateTime now = LocalDateTime.now().minusDays(1);

        LocalDateTime minusDays2 = LocalDateTime.now().minusDays(2);
        Order order1 = new Order();
        order1.setJitTime(now);
        order1.setId(1L);
        order1.setReceiveTime(now);
        Order order2 = new Order();
        order2.setJitTime(minusDays2);
        order2.setReceiveTime(now);
        order2.setId(2L);
        Order order3 = new Order();
        order3.setJitTime(now);
        order3.setReceiveTime(minusDays2);
        order3.setId(3L);

        List<Order> orderList = Lists.newArrayList(order1, order2, order3);


        Optional<Order> packCodeDetailVo = orderList
                .stream()
                .filter(order -> order.getId() == 3)
                .findAny();

        packCodeDetailVo.ifPresent(item -> System.out.println(JsonUtil.toJsonString(item)));

        System.out.println("排序前：" + orderList);
        sort(orderList);
        System.out.println("排序后：" + orderList);

        Map<Long, Order> locatingOrderMap = orderList.stream().collect(Collectors.toMap(Order::getId, Function.identity()));

        List<Long> ids = Lists.newArrayList(1L, 2L, 3L, 4L);
        List<Order> collect = ids.stream().map(id -> locatingOrderMap.get(id)).collect(Collectors.toList());
        System.out.println(collect);

//        List<Long> ids = Sets.new(1L, 2L, 3L, 4L);

        Set<String> set = Sets.newHashSet();
        System.out.println(set.add("1"));
        System.out.println(set.add("1"));
    }


    private static void sort(List<Order> orderList) {
        orderList = orderList.stream()
                .sorted(Comparator.comparing(Order::getJitTime, Comparator.nullsLast(LocalDateTime::compareTo))
                .thenComparing(Order::getReceiveTime, Comparator.nullsLast(LocalDateTime::compareTo)))
                .collect(Collectors.toList());
        setAttribute(orderList);
    }

    private static void setAttribute(List<Order> orders) {
        orders.get(0).setId(10000L);
    }
}
