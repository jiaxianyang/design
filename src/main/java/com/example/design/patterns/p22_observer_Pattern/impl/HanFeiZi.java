package com.example.design.patterns.p22_observer_Pattern.impl;

import com.example.design.patterns.p22_observer_Pattern.IHanFeiZi;

import com.example.design.patterns.p22_observer_Pattern.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * HanFeiZi简介
 *
 * 具体的被观察者
 * @author jiaxianyang
 * @date 2021-10-10 11:44
 */
public class HanFeiZi extends Observable implements IHanFeiZi {

    //定义个变长数组，存放所有的观察者
    private final List<Observer> observerList = new ArrayList<>();

    //韩非子是否在吃饭，作为监控的判断标准
    private volatile boolean isHavingBreakfast = false;

    //韩非子是否在吃饭
    private volatile boolean isHavingFun = false;

//    @Override
//    public void addObserver(Observer observer) {
//        this.observerList.add(observer);
//    }
//
//    @Override
//    public void deleteObserver(Observer observer) {
//        this.observerList.remove(observer);
//    }
//
//    @Override
//    public void notifyObservers(String context) {
//        observerList.forEach(observer -> observer.update(context));
//    }

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子：在吃饭了。。。。");
        isHavingBreakfast = true;
        this.setChanged();
        this.notifyObservers("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子：在娱乐了。。。。");
        isHavingFun = true;
        this.setChanged();
        this.notifyObservers("韩非子在娱乐");
    }

    public boolean isHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setHavingBreakfast(boolean havingBreakfast) {
        isHavingBreakfast = havingBreakfast;
    }

    public boolean isHavingFun() {
        return isHavingFun;
    }

    public void setHavingFun(boolean havingFun) {
        isHavingFun = havingFun;
    }

}
