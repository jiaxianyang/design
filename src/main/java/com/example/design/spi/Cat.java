package com.example.design.spi;

/**
 * @author jiaxianyang
 * @date 2024/7/31 11:08
 */
public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}
