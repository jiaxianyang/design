package com.example.design.base;

import com.google.common.base.Stopwatch;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

class ReflectTest {

    @Test
    @DisplayName("反射测试")
    void reflectTest() throws Exception {
        Class<?> clz = Class.forName("java.lang.String");
        String s = (String) clz.newInstance();
        List<Long> elapsedList = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            Stopwatch started = Stopwatch.createStarted();
            for (int j = 0; j < 100; j++) {
                Class<?> user = Class.forName("com.example.design.common.entity.User");
            }
            Stopwatch stopwatch = started.stop();
            System.out.println("elapsed : " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
            elapsedList.add(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        long sum = elapsedList.stream().mapToLong(millis -> millis).sum();
        System.out.println(sum/20);
        //new  80ms
        // reflect 9576
        System.out.println( 9576 / 80);
    }
}
