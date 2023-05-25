package com.example.design.example;

import com.example.design.utils.SnowflakeSequenceGen;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.SneakyThrows;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BloomFilterExample简介
 * 可能存在误判，当布隆过滤器说某个值存在时，这个值可能不存在；当它说不存在时，那就肯定不存在
 *
 * @author jiaxianyang
 * @date 2023-05-25 13:59
 */
public class BloomFilterExample {

    @SneakyThrows
    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), getExpectedInsertions(), 0.000001);
//        bloomFilter.put("jiaxianyang");
//        bloomFilter.put("666");
//        bloomFilter.put("Hollis");
//        System.out.println(bloomFilter.mightContain("666"));
//        System.out.println(bloomFilter.mightContain("777"));

        SnowflakeSequenceGen snowflakeSequenceGen = new SnowflakeSequenceGen(1, 1);
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < getExpectedInsertions(); i++) {
            String workIdStr = String.valueOf(snowflakeSequenceGen.gen());
            bloomFilter.put(workIdStr);
        }
        int count = 0;
        List< String> wrongIdStrList = Lists.newArrayList();
        for (int i = 0; i < getExpectedInsertions(); i++) {
            String workIdStr = String.valueOf(snowflakeSequenceGen.gen());
            boolean contain = bloomFilter.mightContain(workIdStr);
            if (contain) {
                System.out.println("布隆过滤器判断存在，实际不存在：" +  workIdStr);
                wrongIdStrList.add(workIdStr);
                count++;
            }
        }
        System.out.println("一百万次共有： " + count + "误判" + ", 总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "millis");

        while (true) {
            for (int i = 0; i < getExpectedInsertions(); i++) {
                long Id = snowflakeSequenceGen.gen();
                bloomFilter.mightContain(String.valueOf(Id));
            }
            Thread.sleep(1000);
            System.out.println("布隆过滤器判断中");
        }

    }

    private static int getExpectedInsertions() {
        return 10000000;
    }
}
