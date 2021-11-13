package com.example.design.patterns.p22_observer_Pattern;

/**
 * ILiSi简介
 *
 * 观察者
 * @author jiaxianyang
 * @date 2021-10-10 11:48
 */
public interface Observer {
    //一发现别人有动静，自己也要行动起来
    public void update(String context);
}
