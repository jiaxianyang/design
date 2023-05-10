package com.example.design.base;

import com.example.design.common.entity.Person;
import com.example.design.common.entity.Son;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListTestGroupBy {

    public static void main(String[] args) {
        List codes1 = Lists.newArrayList("a", "b");
//        for (int i = 0; i < 100; i++) {
//            codes1.add("a");
//            codes1.add("b");
//        }
        List codes2 = Lists.newArrayList("b", "a");
//        for (int i = 0; i < 100; i++) {
//            codes2.add("b");
//            codes2.add("a");
//        }
        Person person1 = new Person();
        Person person2 = new Person();
        person1.setCodes(codes1);
        person1.setName("a");
        person2.setCodes(codes2);
        person2.setName("a");
        ArrayList<Person> personList = Lists.newArrayList(person1, person2);
        personList.forEach(person ->
                person.setCodes(sortList(person.getCodes()))
        );
        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(person ->
                StringUtils.join(
                        ListTestGroupBy.sortList(person.getCodes()),
                        ListTestGroupBy.sortList(person.getSonNames()),
                        person.getName()))
        );
        System.out.println(collect);
        System.out.println(collect.size());
    }

    /**
     * codes
     *
     * @param waitSortedList
     * @return
     */
    private static List<String> sortList(List<String> waitSortedList) {
        if (CollectionUtils.isEmpty(waitSortedList)) {
            return null;
        }
        return waitSortedList.stream().sorted().collect(Collectors.toList());
    }

}
