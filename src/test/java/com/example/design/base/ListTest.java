package com.example.design.base;

import com.example.design.common.entity.Person;
import com.example.design.common.entity.Son;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
        List<Person> list = Lists.newArrayList();
        List<Son> sonList = Lists.newArrayList();
        list.stream().forEach(person -> sonList.addAll(person.getSonList()));

        Map<String, List<Son>> collect = sonList.stream().collect(Collectors.groupingBy(Son::getName));
        System.out.println(collect);
    }
}
