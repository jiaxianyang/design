package com.example.design.base;

import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jiaxianyang
 * @date 2024/5/18 15:08
 */
public class DisruptorTest {

    private static final long calCount = 500000000;
    public static volatile long curLong = 0;
    public static void main(String[] args) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(0);

        long currentTimeMillis = System.currentTimeMillis();
         long tempLong = 0;
        while (true) {
            synchronized (DisruptorTest.class) {
                curLong++;
            }
            if (curLong > calCount) {
                break;
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - currentTimeMillis));
    }
}

//long 耗时：141
//volatile 耗时：988
//AtomicLong 耗时：2329
//synchronized 耗时：2421
