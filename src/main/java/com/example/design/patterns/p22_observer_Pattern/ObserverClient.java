package com.example.design.patterns.p22_observer_Pattern;

import com.example.design.patterns.p22_observer_Pattern.impl.HanFeiZi;
import com.example.design.patterns.p22_observer_Pattern.impl.LiSi;

public class ObserverClient {

    public static void main(String[] args) throws InterruptedException {
//        LiSi liSi = new LiSi();
//        HanFeiZi hanFeiZi = new HanFeiZi();
//        //观察早餐
//        Spy spyBreakfast = new Spy(hanFeiZi, liSi, "breakfast");
//        spyBreakfast.start();
//
//        //观察娱乐活动
//        Spy spyFun = new Spy(hanFeiZi, liSi, "fun");
//        spyFun.start();
//
//        //然后我们看看韩非子在干什么
//        Thread.sleep(1000);
//        //主线程等待1秒后后再往下执行
//
//        hanFeiZi.haveBreakfast();
//        //韩非子娱乐了
//        Thread.sleep(1000);
//        hanFeiZi.haveFun();
//
//        Thread.sleep(5000);
//        spyBreakfast.interrupt();
//        spyFun.interrupt();

//        jdk 提供的观察者
        java.util.Observer liSi = new LiSi();


        //定义出韩非子
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(liSi);


        //然后这里我们看看韩非子在干什么
        hanFeiZi.haveBreakfast();

        hanFeiZi.haveFun();
        }
}
