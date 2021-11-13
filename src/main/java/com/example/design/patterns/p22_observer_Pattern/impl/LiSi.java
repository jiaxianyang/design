package com.example.design.patterns.p22_observer_Pattern.impl;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class LiSi implements Observer {

    //首先李斯是个观察者，一旦韩非子有活动，他就知道，他就要向老板汇报
    public void update(String context) {
        System.out.println("李斯:观察到韩非子活动，开始向老板汇报了...");
        this.reportToQinShiHuang(context);
        System.out.println("李斯:汇报完毕...\n");
    }
    //汇报给秦始皇
    private void reportToQinShiHuang(String reportContext) {
        List<Integer> res = new ArrayList<>(100000000);
        for (int i = 0; i < 10000000; i++) {
            Random random = new Random();
            res.add(random.nextInt(1000000));
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Collections.sort(res);
        }
        System.out.println("李斯:报告，秦老板!韩非子有活动了--->" + reportContext + " elapsed---> " + (System.currentTimeMillis() - start) + " ms");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("李斯:观察到韩非子活动，开始向老板汇报了...");
        this.reportToQinShiHuang(o.toString());
        System.out.println("李斯:汇报完毕...\n");
    }
}
