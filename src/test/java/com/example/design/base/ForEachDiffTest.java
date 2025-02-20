package com.example.design.base;

import java.util.Arrays;
import java.util.List;

/**
 * @author jiaxianyang
 * @date 2024/6/25 13:59
 */
public class ForEachDiffTest {
    public static void main(String[] args) {
// forEach with return
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(item -> {
            if ("b".equals(item)) {
                return; // Exits the current lambda execution for this item
            }
            System.out.println(item); // Prints "a" and "c"
        });

// for loop with continue
        for (String item : list) {
            if ("b".equals(item)) {
                continue; // Skips the rest of the loop body for this iteration
            }
            System.out.println(item); // Prints "a" and "c"
        }

    }
}
