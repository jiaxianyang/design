package com.example.design.base;

import com.example.design.common.exception.WmsBusinessException;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ThreadTest {
    public static void main(String[] args) {

        try {
            List<CompletableFuture<String>> futures = new ArrayList<>(2);
            List<ThreadTaskByOrderDetailLocating> threadTaskByOrderDetailLocatings = new ArrayList<>();
            threadTaskByOrderDetailLocatings.add(new ThreadTaskByOrderDetailLocating());
            for (ThreadTaskByOrderDetailLocating threadTaskByOrderDetailLocating : threadTaskByOrderDetailLocatings) {
                futures.add(CompletableFuture.supplyAsync(threadTaskByOrderDetailLocating::run, createThreadPoolForLocatingOrderDetail()));
            }
            List<String> locateResultVos = futures.stream().map(CompletableFuture::join).collect(Collectors.toList());

//            throw new WmsBusinessException(22,"Anastasia业务异常");
            throw new WmsBusinessException(22,"Anastasia业务异常");
//            int b =2/0;
        } catch (Exception e) {
            if (e.getCause() != null) {
                if (e.getCause() instanceof WmsBusinessException) {
                    System.out.println("子线程出现业务异常了...." + e);
                }else {
                    System.out.println("子线程出现系统异常了...." + e);
                }
            }else {
                if (e instanceof WmsBusinessException) {
                    System.out.println("主线程出现业务异常了...." + e);
                }else {
                    System.out.println("主线程出现系统异常了...." + e);
                }
            }
        }

        System.out.println("===");
    }

    private static ThreadPoolExecutor createThreadPoolForLocatingOrderDetail() {
        return new ThreadPoolExecutor(5
                , 5
                , 5
                , TimeUnit.SECONDS
                , new LinkedBlockingQueue<>(5)
                , new ThreadFactoryBuilder().setNameFormat("ConcurrentOrderLocatingPolicy-%s").build()
                , new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static class ThreadTaskByOrderDetailLocating {
        public String run(){
//            try {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            int a =1/0;
//            } catch (Exception e) {
//                throw new IllegalStateException("系统异常啦", e);
//                throw new WmsBusinessException(11,"Anastasia业务异常");
//            throw new RuntimeException("Anastasia业务异常");
//            }
            return "aa";
        }
    }
}
