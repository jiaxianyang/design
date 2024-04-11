package com.example.design.base;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ExtendWith(MockitoExtension.class)
public class ThreadPoolExecutorTest {

    ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 3, 30, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(2), new ThreadFactoryBuilder().setNameFormat("test-%s").build()
            , new ThreadPoolExecutor.DiscardPolicy());

        @Test
        public void test() throws InterruptedException, ExecutionException {


            //每隔两秒打印线程池的信息
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                System.out.println("=====================================thread-pool-info:" + new Date() + "=====================================");
                System.out.println("CorePoolSize:" + executorService.getCorePoolSize());
                System.out.println("PoolSize:" + executorService.getPoolSize());
                System.out.println("ActiveCount:" + executorService.getActiveCount());
                System.out.println("KeepAliveTime:" + executorService.getKeepAliveTime(TimeUnit.SECONDS));
                System.out.println("QueueSize:" + executorService.getQueue().size());
            }, 0, 2, TimeUnit.SECONDS);

//            try {
//                //同时提交5个任务,模拟达到最大线程数
//                for (int i = 0; i < 5; i++) {
//                    executorService.execute(new Task());
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            //休眠10秒，打印日志，观察线程池状态
            Thread.sleep(10000);

            //每隔3秒提交一个任务
            while (true) {
                executorService.execute(new Task());
                Thread.sleep(3000);
            }
        }

        static class Task implements Runnable {
            @Override
            public void run(){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "-执行任务");
                throw new RuntimeException();
            }
        }

}
