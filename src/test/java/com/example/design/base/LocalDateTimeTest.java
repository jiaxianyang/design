package com.example.design.base;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTimeTest简介
 *
 *
 * @author jiaxianyang
 * @date 2022-05-12 14:19
 */
class LocalDateTimeTest {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    /**
     * 总结：
     * 1、plusMinutes: 相当于时间增加多少分钟、过了多少分钟、流逝多少分钟
     * 例如： 当前时间： 2022-05-12 14:19:21  调用 plusMinutes(30) 之后 2022-05-12 14:49:21
     *
     * 2、Duration.between(start, end);
     * start: 2022-05-12 14:19:21
     * end: 2022-05-12 14:49:21
     * 结果：30
     * start 为之前的时候， end为之后的时间，结果为整数， 反之为负数。
     */
    @Test
    void test() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(30);
        System.out.println("now : start " + dtf.format(start));
        System.out.println("plusNow : end: " + dtf.format(end));
        System.out.println("时间早的在前正数: " + (int) Duration.between(start, end).toMinutes());
        System.out.println("时间之后的在前负数: " + (int) Duration.between(end, start).toMinutes());
    }


    @Test
    void testCheckIsToday() {

//        localDateTime.isAfter(startTime) && localDateTime.isBefore(endTime) ||

        LocalDateTime startTime = LocalDate.now().atTime(0, 0, 0);
        LocalDateTime firstTimeOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime endTime = LocalDate.now().atTime(23, 59, 59);
        System.out.println(checkIsToday(startTime));
    }





    private boolean checkIsToday(LocalDateTime localDateTime) {
        LocalDateTime startTime = LocalDate.now().atTime(0, 0, 0);
        LocalDateTime endTime = LocalDate.now().atTime(23, 59, 59);
        //如果大于今天的开始日期，小于今天的结束日期
        return localDateTime.compareTo(startTime) >= 0 && localDateTime.compareTo(endTime) <=0;
    }
}
