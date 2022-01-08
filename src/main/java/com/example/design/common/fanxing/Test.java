package com.example.design.common.fanxing;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        //上界通配符
        List<? extends Animal> list = new ArrayList<Cat>();
        //下界通配符
        List<? super Cat> result = new ArrayList<Animal>();

        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        Method m = al.getClass().getMethod("add", Object.class);
        m.invoke(al, "hello");
        System.out.println(al.get(2));

    }
}
