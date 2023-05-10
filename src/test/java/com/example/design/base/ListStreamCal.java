package com.example.design.base;

import com.example.design.common.entity.Person;
import com.example.design.common.entity.Son;
import com.example.design.utils.json.JsonUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListStreamCal {

    public static void main(String[] args) {
        Person person1 = new Person();
        Son son11 = new Son();
        Son son12 = new Son();
        person1.setSonList(Lists.newArrayList(son11, son12));
        Person person2 = new Person();
        Son son21 = new Son();
        Son son22 = new Son();
        person2.setSonList(Lists.newArrayList(son21, son22));

        List<Person> peopleList = Lists.newArrayList(person1, person2);
        List<Person> peopleList1 = Lists.newArrayList();

        long max = peopleList.stream().map(Person::getSonList)
                .flatMap(Collection::stream)
                .filter(son -> Objects.nonNull(son.getId()))
                .mapToLong(Son::getId).max().orElse(0);
        System.out.println(max);

        int sum = peopleList.stream().filter(person -> CollectionUtils.isNotEmpty(person.getSonList()))
                .mapToInt(person -> CollectionUtils.size(person.getSonList()))
                .sum();
        System.out.println(sum);

        System.out.println("peopelList1 size: " + (peopleList1.size() - 1));
        System.out.println( 0 <= (peopleList1.size() - 1));


        peopleList.get(0).getSonList().get(0).setAccount(BigDecimal.TEN);

        //计算箱实际称重重量
        BigDecimal totalAccount = peopleList.stream()
                .filter(item -> CollectionUtils.isNotEmpty(item.getSonList()))
                .map(Person::getSonList)
                .flatMap(Collection::stream)
                .filter(son -> Objects.nonNull(son.getAccount()))
                .map(Son::getAccount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("total: " + totalAccount);
    }

    @Test
    void  testPratition() {
        List<Person> zoneList = com.google.common.collect.Lists.partition(Lists.newArrayList(), 200)
                .stream()
                .map(subZoneList -> {
                    Person person = new Person("name", 10);
                    return Lists.newArrayList(person);
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Map<String, Person> collect =
                zoneList.stream().collect(Collectors.toMap(Person::getName, Function.identity(), (o1, o2) -> o1));

        System.out.println(JsonUtil.toJsonString(collect));
        System.out.println(collect.get(null));
        System.out.println(collect.get(""));
    }


    @Test
    void  testArrayStream() {
        String batchLimitWhiteList = "6_6_618,6_6_601";
        boolean b = !Arrays.stream(batchLimitWhiteList.split(",")).collect(Collectors.toSet()).contains("6_6_601");
        System.out.println(b);
    }


}
