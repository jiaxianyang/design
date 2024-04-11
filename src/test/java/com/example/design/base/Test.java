package com.example.design.base;

import java.time.Duration;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
//        System.out.println(2 * 2 * 2 * 2 * 2);
//        System.out.println(2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2);
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime endBefore = LocalDateTime.now();
        LocalDateTime start = LocalDateTime.now();
        System.out.println("end :" + end);
        System.out.println("endBefore :" + endBefore);
        System.out.println("start :" + start);
        System.out.println(Duration.between(end, start).toMinutes());
    }
}


