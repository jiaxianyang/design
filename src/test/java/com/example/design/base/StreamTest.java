package com.example.design.base;

import com.example.design.common.entity.Person;
import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        Person jia = Person.builder()
                .name("jia")
                .age(18)
                .weight(new BigDecimal(10.0))
                .build();

        Person ren = Person.builder()
                .name("ren")
                .age(19)
                .weight(new BigDecimal(11.0))
                .build();

        List<Person> peoples = Lists.newArrayList(jia, ren);

//        List<Integer> ages = peoples.stream().filter(person -> person.getName().equals("jia")).map(Person::getAge).collect(Collectors.toList());
//        System.out.println(ages);
//        List<Person> collect = peoples.stream().map(person -> getPerpon(person)).collect(Collectors.toList());
//        Map<String, Person> collect1 = collect.stream()
//                .collect(Collectors.toMap(Person::getName, Function.identity(), (k1, k2) -> k2));
//        System.out.println(collect1);


        System.out.println(peoples.stream().map(Person::getWeight).reduce(BigDecimal::add));
    }

    private static Person getPerpon(Person person) {
        return null;
    }
}
