package com.example.design.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author jiaxianyang
 * @date 2024/4/11 12:05
 */
public class GrabRedEnvelopes {

    /**
     * 二倍均值法,分配红包金额
     *
     * @param totalAmount    单位为分
     * @param totalPeopleNum 人数
     * @return
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restpeopleNum = totalPeopleNum;
        Random random = new Random();
        // 最后一个人不用随机分配了，之间差值
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            //随机分配的范围： [1, 剩余人均金额的2倍 - 1分]
            // + 1的原因是：random.nextInt 随机返回一个值在[0,num)的int类型的整数，包裹0 不包括num
            // random.nextInt + 1 的范围是 [1 ,num + 1) 也就是 [1, num]
            //就满足了随机区间：[1, m/n * 2 - 1] 分
            int amount = random.nextInt((restAmount / restpeopleNum) * 2 - 1) + 1;
            restAmount = restAmount - amount;
            restpeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> result = divideRedPackage2(100, 10);
        System.out.println(result);
        System.out.println(result.stream().mapToInt(Integer::intValue).sum());
    }


    /**
     * 线段切割法
     *
     * @param totalAmount
     * @param totalPeopleNum
     * @return
     */
    public static List<Integer> divideRedPackage2(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Set<Integer> segments = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            //切割的位置segment,随机的范围区间是[1, m - 1]
            int segment = random.nextInt(totalAmount - 2) + 1;
            //delta == 1
            random.nextInt(1);
            int delta = 1;
            // segments.contains(segment) ==true 表示切割位置重复
            //segment == 0,切割位置不正确
            while (segments.contains(segment) || segment == 0) {
                // 加上 1位，用来解决以上俩个问题
                //%totalAmount
                segment = (segment + delta) % totalAmount;
            }
            segments.add(segment);
        }
        //依据切割的段来划分 钱数
        //从HashSet取值
        //Collections.sort排序方法，把切割位置从小到大排序。
        List<Integer> segmentList = new ArrayList<>(segments);
        Collections.sort(segmentList);
        for (int i = 0; i < segmentList.size(); i++) {
            Integer amount;
            if (i == 0) {
                amount = segmentList.get(0);
            } else {
                amount = segmentList.get(i) - segmentList.get(i - 1);
            }
            amountList.add(amount);
        }
        amountList.add(totalAmount - segmentList.get(segmentList.size() - 1));
        return amountList;
    }
}
