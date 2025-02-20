package com.example.design.base;

/**
 * @author jiaxianyang
 * @date 2025/1/24 21:45
 */
public class BooleanTest {

    public static void main(String[] args) {
        boolean flag  = true;
        boolean simpleBoolean = false;
        Boolean nullBoolean = null;
        System.out.println(flag ? nullBoolean : simpleBoolean);
    }
}
