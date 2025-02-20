package com.example.design.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@ExtendWith(MockitoExtension.class)
public class SetTest {

    @Test
    @DisplayName("set  排序测试")
    void test() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        System.out.println(set1);
        for (String set : set1) {
            System.out.println(set);
        }

        Set<String> set2 = new HashSet<>();
        set2.add("a");
        set2.add("b");
        set2.add("c");
        System.out.println(set1.equals(set2));

        Map<Object, Object> map = new HashMap<>();
        map.put(set1, "a");
        if (map.containsKey(set2)) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }
    }



    @Test
    @DisplayName("set  排序测试")
    void test2() {
        Set<String> set1 = new HashSet<>();
        set1.add("c");
        set1.add("b");
        set1.add("a");

        System.out.println(set1);

        for (String set : set1) {
            System.out.println(set);
        }
    }
}
