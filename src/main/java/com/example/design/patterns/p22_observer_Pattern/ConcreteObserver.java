package com.example.design.patterns.p22_observer_Pattern;

/**
 * ConcreteObserver简介
 *
 * 具体观察者
 * @author jiaxianyang
 * @date 2021-10-11 20:39
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update(String context) {
        System.out.println("接收到信息，并进行处理!");
    }
}
