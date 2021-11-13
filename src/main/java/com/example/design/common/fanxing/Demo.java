package com.example.design.common.fanxing;

public class Demo {

    public static void main(String[] args) {
        Demo d = new Demo();
        String str = d.fun("汤姆");
        Integer i = d.fun(30);
        System.out.println(str);
        System.out.println(i);
    }

    public <T> T fun(T t) {
        return t;
    }
}
