package com.example.design.patterns.p22_observer_Pattern.impl;

import com.example.design.patterns.p22_observer_Pattern.Observer;

public class LiuSi implements Observer {

    @Override
    //刘斯，观察到韩非子活动后，自己也得做一些事
    public void update(String str) {
        System.out.println("刘斯:观察到韩非子活动，开始动作了...");
        this.happy(str);
        System.out.println("刘斯:乐死了\n");
    }

    //一看韩非子有变化，他就快乐
    private void happy(String context) {
        System.out.println("刘斯:因为" + context + ",--所以我快乐呀!");
    }
}
