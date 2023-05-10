package com.example.design.base;

import com.example.design.utils.json.JsonUtil;
import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args) throws InterruptedException {
//
//
//        List<List<String>> partition = Lists.newArrayList();
//        for (List<String> strings : partition) {
//            System.out.println(strings);
//        }
//        System.out.println(partition.get(0));


        int[] nums = {2, 9, 1, 10, 0, 11, 9, 13};
        Arrays.sort(nums);
        System.out.println(JsonUtil.toJsonString(nums));
        System.out.println(0 / 2 + 1);
    }
}
