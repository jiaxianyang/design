package com.example.design.patterns.p22_observer_Pattern.impl;

/**
 * Spy简介
 * <p>
 * 间谍
 *
 * @author jiaxianyang
 * @date 2021-10-10 11:51
 */
public class Spy extends Thread {
    private HanFeiZi hanFeiZi;
    private LiSi liSi;
    private String type;

    //通过构造函数传递参数，我要监控的是谁，谁来监控，要监控什么
    public Spy(HanFeiZi hanFeiZi, LiSi liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            if (this.type.equals("breakfast")) {
                if (this.hanFeiZi.isHavingBreakfast()) {
                    this.liSi.update("韩非子在吃饭");
                    this.hanFeiZi.setHavingBreakfast(false);
                }
            } else {
                if (this.hanFeiZi.isHavingFun()) {
                    this.liSi.update("韩非子在娱乐");
                    this.hanFeiZi.setHavingFun(false);
                }
            }
        }
    }

}
