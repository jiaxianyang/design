package com.example.design.base;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("1");
        BigDecimal bigDecimal0 = new BigDecimal("0");
        BigDecimal bigDecimal_1 = new BigDecimal("-1");
        System.out.println(BigDecimal.ZERO.compareTo(bigDecimal1));
        System.out.println(BigDecimal.ZERO.compareTo(bigDecimal0));
        System.out.println(BigDecimal.ZERO.compareTo(bigDecimal_1));
    }
}
