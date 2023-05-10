package com.example.design.base;

import com.example.design.common.entity.Person;
import com.google.common.collect.ComparisonChain;
import org.assertj.core.util.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setAge(1);
        person1.setName("jia1");

        Person person2 = new Person();
        person2.setAge(2);
        person2.setName("jia2");

        Person person3 = new Person();
        person3.setAge(3);
        person3.setName("jia3");

        Person person4 = new Person();
        person4.setAge(4);
        person4.setName("jia4");

        Person person5 = new Person();
        person5.setAge(5);
        person5.setName("jia5");

        Person person6 = new Person();
        person6.setAge(6);
        person6.setName("jia6");

        Person person7 = new Person();
        person7.setAge(7);
        person7.setName("jia7");

        Person person8 = new Person();
        person8.setAge(8);
        person8.setName("jia8");

        Person person9 = new Person();
        person9.setAge(9);
        person9.setName("jia9");

        List<Person> persons = Lists.newArrayList();

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);
        persons.add(person9);


        List<Person> reversedSortList = persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());

        List<Person> sortList = reversedSortList.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        System.out.println(persons);
        System.out.println(sortList);


        persons.sort(((o1, o2) -> ComparisonChain.start().compare(o1.getAge(), o2.getAge()).result()));
        System.out.println(persons);

        persons.sort((o1, o2) -> o1.getAge() - o2.getAge());

        System.out.println(persons);

        persons.sort((o1, o2) -> o2.getAge() - o1.getAge());

        System.out.println(persons);
    }


}
