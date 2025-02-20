package com.example.design.spi;

/**
 * @author jiaxianyang
 * @date 2024/7/31 11:08
 */
public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}
