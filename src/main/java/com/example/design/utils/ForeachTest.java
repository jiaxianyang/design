package com.example.design.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaxianyang
 * @date 2024/10/8 14:52
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        StringBuilder str = new StringBuilder();
        list.forEach(v -> {
            str.append(v).append(System.lineSeparator());
        });
        System.out.println(str.toString());
        for (int i = list.size() - 1; i >= 0; i--) {
            if ("a".equals(list.get(i))) {
                list.remove(list.get(i));
            }
        }
        System.out.println(list);

    }

}
