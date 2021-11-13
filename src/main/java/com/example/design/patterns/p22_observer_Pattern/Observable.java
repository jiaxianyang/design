package com.example.design.patterns.p22_observer_Pattern;

/**
 * Observable简介
 *
 * 被观察者接口
 * @author jiaxianyang
 * @date 2021-10-11 11:31
 */
public interface Observable {
    //增加一个观察者
    public void addObserver(Observer observer);
    //删除一个观察者
    public void deleteObserver(Observer observer);
    //既然要观察，我发生改变了他也应该有所动作，通知观察者
    public void notifyObservers(String context);
}
