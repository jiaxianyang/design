package com.example.design.base;

public class DefaultValueTest {
    public static void main(String[] args) {
        NodeProcessContext nodeProcessContext = new NodeProcessContext();

        System.out.println(nodeProcessContext);

        NodeProcessContext build = NodeProcessContext.builder().build();
        System.out.println(build);
    }
}
