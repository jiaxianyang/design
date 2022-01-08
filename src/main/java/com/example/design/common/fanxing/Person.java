package com.example.design.common.fanxing;

public class Person<E> {

    public static void main(String[] args) {
        new Person(22);

        new <String>Person("hello");

        Person<String> person = new Person<>("sss");

    }

    public <T> Person(T t) {
        System.out.println(t);
    }

}
