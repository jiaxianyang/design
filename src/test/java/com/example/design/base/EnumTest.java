package com.example.design.base;

import com.example.design.common.enums.OrderNodeMsgEnum;

import java.util.Arrays;

public class EnumTest {
    public static void main(String[] args) {
//        OrderNodeMsgEnum orderNodeMsgEnum = OrderNodeMsgEnum.valueOf("");
//        System.out.println(orderNodeMsgEnum);
//        OrderNodeMsgEnum restart = OrderNodeMsgEnum.valueOf("RESTART");
//        System.out.println(restart);


        OrderNodeMsgEnum nodeMsgEnum = Arrays.stream(OrderNodeMsgEnum.values()).filter(value -> value.name().equals("")).findFirst().orElse(null);
        System.out.println(nodeMsgEnum);

        OrderNodeMsgEnum nodeMsgEnum2 = Arrays.stream(OrderNodeMsgEnum.values()).filter(value -> value.name().equals("RESTART")).findFirst().orElse(null);
        System.out.println(nodeMsgEnum2);
    }
}
