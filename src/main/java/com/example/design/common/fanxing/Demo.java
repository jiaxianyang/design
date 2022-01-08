package com.example.design.common.fanxing;

import com.google.common.collect.Lists;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Demo d = new Demo();
        String str = d.fun("汤姆");
        Integer i = d.fun(30);
        System.out.println(str);
        System.out.println(i);

        List<String> list = Lists.newArrayList();
    }

    public <T> T fun(T t) {
        return t;
    }

    public <E> void go(E e) {
        return;
    }
}
