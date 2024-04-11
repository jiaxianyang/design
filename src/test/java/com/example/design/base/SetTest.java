package com.example.design.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    @Test
    @DisplayName("set  排序测试")
    public void test() {
        Set<String> sets = new HashSet<>();
        sets.add("a");
        sets.add("b");
        sets.add("c");
        System.out.println(sets);
        for (String set : sets) {
            System.out.println(set);
        }
    }
}
