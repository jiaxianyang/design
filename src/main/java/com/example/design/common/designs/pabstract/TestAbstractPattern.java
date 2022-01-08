package com.example.design.common.designs.pabstract;

public class TestAbstractPattern {
    public static void main(String[] args) {
        System.out.println("第一道菜开始制作");
        ConcreteClassBaoCai baoCai = new ConcreteClassBaoCai();
        baoCai.cookProcess();
        System.out.println("第二道菜开始制作");
        ConcreteClassJieLan jieLan = new ConcreteClassJieLan();
        jieLan.cookProcess();
    }
}
