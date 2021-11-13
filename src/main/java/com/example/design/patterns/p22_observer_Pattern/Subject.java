package com.example.design.patterns.p22_observer_Pattern;

import java.util.Vector;

public abstract class Subject {

    //定义一个观察者数组
    private Vector<Observer> obsVector = new Vector<>();
    //增加一个观察者
    public void addObserver(Observer observer){
        this.obsVector.add(observer);
    }

    //删除一个观察者
    public void delObserver(Observer observer){
        this.obsVector.remove(observer);
    }

    //通知所有观察者
    public void notifyObservers() {
        obsVector.forEach(observer -> observer.update(""));
    }
}
