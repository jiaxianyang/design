package com.example.design.base;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jiaxianyang
 * @date 2024/2/28 10:53
 */
public class ThreadPoolExecutorDeadTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = buildThreadPoolExecutor();
        executorService.submit(() -> exeTask("execute"));
        executorService.submit(() -> exeTask("execute"));
        executorService.submit(() -> exeTask("execute-exception"));
        executorService.submit(() -> exeTask("execute"));
        executorService.submit(() -> exeTask("execute"));


        Thread.sleep(5000);
        System.out.println("再次执行任务=======================");

        executorService.submit(() -> exeTask("execute"));
        executorService.submit(() -> exeTask("execute"));
        executorService.submit(() -> exeTask("execute"));
        executorService.submit(() -> exeTask("execute"));
        executorService.submit(() -> exeTask("execute"));
    }


    public static ExecutorService buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(5, 10, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000), new ThreadFactoryBuilder().setNameFormat("test-%s").build()
                , new ThreadPoolExecutor.CallerRunsPolicy());
    }

    private static void exeTask(String name) {
        String printStr = "[thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name + "]";
        if ("execute-exception".equals(name)) {
            throw new RuntimeException(printStr + ", 我抛异常了");
        } else {
            System.out.println(printStr);
        }
    }
}
