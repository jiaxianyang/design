package com.example.design.base;

public class TestJVM {
    public static void main(String[] args) {
        String strValue = System.getProperty("str");
        if (strValue == null) {
            System.out.println("null");
        } else {
            System.out.println(strValue);
        }
    }
}
