package com.example.design.common.designs.pabstract;

public class ConcreteClassJieLan extends AbstractClass {
    @Override
    protected void pourVegetable() {
        System.out.println("Step:2 下锅的蔬菜是芥兰");
    }

    @Override
    protected void pourSauce() {
        System.out.println("Step:3 下锅的酱料是姜丝");
    }
}
