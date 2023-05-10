package com.example.design.base;

import com.example.design.common.entity.Person;
import org.apache.commons.collections4.MapUtils;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Optional<Person> optional = Optional.empty();
        System.out.println(optional.orElse(new Person("jia", 1)));


        System.out.println(MapUtils.getBoolean(null, "a"));
    }

    private static int getMidNum(int lo, int hi) {
        return (hi - lo) / 2 + lo;
    }
}


