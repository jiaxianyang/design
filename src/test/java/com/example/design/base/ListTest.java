package com.example.design.base;

import com.example.design.common.entity.Person;
import com.example.design.common.entity.Son;
import com.google.common.collect.ImmutableList;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
//        List<Person> list = Lists.newArrayList();
//        List<Son> sonList = Lists.newArrayList();
//        list.stream().forEach(person -> sonList.addAll(person.getSonList()));
//
//        Map<String, List<Son>> collect = sonList.stream().collect(Collectors.groupingBy(Son::getName));
//        System.out.println(collect);

        List<Person> personList = new ArrayList<>();
        Person p1 = new Person("xiaoming",1);
        Person p2 = new Person("xiaoming",2);
        Person p3 = new Person("xiaoxin",4);
        Person p4 = new Person("xiaoxin",5);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        //必须全部都满足才会返回true
        System.out.println(String.format("allMatch结果：%s", personList.stream().allMatch(person -> (person.getAge() == 5 ))));

        //全都不满足才会返回true
        System.out.println(String.format("noneMatch结果：%s", personList.stream().noneMatch(person -> (person.getAge() == 5 ))));

        //只要有一个条件满足即返回true
        System.out.println(String.format("anyMatch结果：%s", personList.stream().anyMatch(person -> (person.getAge() == 5 ))));

        //如果为空List
        List<Person> emptyPerponList = Lists.newArrayList();

        //必须全部都满足才会返回true
        System.out.println(String.format("empty List allMatch结果：%s", emptyPerponList.stream().allMatch(person -> (person.getAge() == 5 ))));

        //全都不满足才会返回true
        System.out.println(String.format("empty List noneMatch结果：%s", emptyPerponList.stream().noneMatch(person -> (person.getAge() == 5 ))));

        //只要有一个条件满足即返回true
        System.out.println(String.format("empty List anyMatch结果：%s", emptyPerponList.stream().anyMatch(person -> (person.getAge() == 5 ))));


        ImmutableList<Person> peopleListCopy = ImmutableList.copyOf(personList);
        System.out.println(personList);
        peopleListCopy.get(0).setAge(99);
        System.out.println(peopleListCopy);


        List<Person> resultList = personList.stream()
                // 先按年龄排序的，这样名字相同的年龄大的肯定在前面
                .sorted((h1, h2) -> h2.getAge() - h1.getAge())
                // 根据名字去重
                .filter(distinctByName(Person::getName))
                .collect(Collectors.toList());

        System.out.println(personList);
        System.out.println(resultList);
    }

    public static <T> Predicate<T> distinctByName(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
