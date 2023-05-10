package com.example.design.base;

import com.example.design.utils.SnowflakeSequenceGen;
import com.example.design.utils.json.JsonUtil;
import lombok.SneakyThrows;
import org.assertj.core.util.Lists;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class AsyncTest {

    private static SnowflakeSequenceGen sequenceGen = new SnowflakeSequenceGen(1, 1);

    private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    private final static ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(AVALIABLE_PROCESSORS, AVALIABLE_PROCESSORS * 2, 1,
            TimeUnit.MINUTES, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long beginTime = System.currentTimeMillis();



//        ===============================1、创建线程=======================================
//        //1.开启新线程
//        Thread newThread = new Thread(() -> {
//            //2.新线程执行任务A
//            try {
//                doTaskA();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "newThread");
//
//        newThread.start();
//        //2. 执行任务
//        doTaskB();
//        //3.同步等待新线程结束
//        newThread.join();

        //        ===============================2、使用线程池=======================================
//           POOL_EXECUTOR.execute(()-> {
//               try {
//                   doTaskA();
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//           });
//           doTaskB();

        //        ===============================3、使用线程池获取返回值=======================================
//        Future<?> resultA = POOL_EXECUTOR.submit(() -> doTaskA());
//        doTaskB();
//        System.out.println(resultA.get());


        //        ===============================4、JDK的FutureTask实现异步编程=======================================
//
//        FutureTask<String> futureTask = new FutureTask<>(() -> doTaskA());
//        POOL_EXECUTOR.execute(futureTask);
//        doTaskB();
//        System.out.println(futureTask.get());

        //        ===============================5、JDK的CompletableFuture实现异步编程=======================================

//        CompletableFuture<String> future = new CompletableFuture<>();
//        POOL_EXECUTOR.execute(() -> {
//            try {
//                String result = doTaskA();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //设置计算结果到future
//            future.complete("world");
//        });
//        doTaskB();
//        System.out.println(future.get());

        //        ===============================5、JDK的CompletableFuture实现异步编程、基于runAsync系列方法实现无返回值的异步计算=======================================

//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            try {
//                doTaskA();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("taskA complete");
//        });
//        doTaskB();
//        System.out.println(future.get());

        //        ===============================5、JDK的CompletableFuture实现异步编程、基于supplyAsync系列方法实现有返回值的异步计算=======================================
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                return doTaskA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "fail";
        });
        doTaskB();
        System.out.println(future.get());
//          还可以基于thenRun实现异步任务A，执行完毕后，激活异步任务B执行，需要注意的是，这种方式激活的异步任务B是拿不到任务A的执行结果的；
//        基于thenAccept实现异步任务A，执行完毕后，激活异步任务B执行，需要注意的是，这种方式激活的异步任务B是可以拿到任务A的执行结果的；
//        基于thenApply实现异步任务A，执行完毕后，激活异步任务B执行。需要注意的是，这种方式激活的异步任务B是可以拿到任务A的执行结果的，并且可以获取到异步任务B的执行结果。


        //        ===============================6、Spring注解实现异步执行=======================================

//        @EnableAsync
//        @Component
//        public class AsyncAnnotationExample  {
//            @Async
//            public void doTaskA(){
//       ...
//            }
//        }
//        由于写法不规范常常会出现@Async注解失效的情况，常见失效情况如下：
//        注解@Async的方法不是public⽅法;
//        注解@Async的返回值只能为void或者Future;
//        注解@Async方法使用static修饰也会失效;
//        spring无法扫描到异步类，没加注解@Async 或@EnableAsync注解;
//        调用方与被调方不能在同⼀个类;
//        类中需要使用@Autowired或@Resource等注解自动注入，不能自己手动new对象;
//        在Async 方法上标注@Transactional是没用的，但在Async方法调用的方法上标注@Transactional 是有效的。


        System.out.println("耗时： " + (System.currentTimeMillis() - beginTime) + "ms");
        POOL_EXECUTOR.shutdown();
    }

    private static String doTaskB() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        try {
            Thread.sleep(300);
            List<? extends Serializable> list = Lists.newArrayList("a", sequenceGen.gen(), "doTaskA");
            return JsonUtil.toJsonString(list);
        } finally {
            System.out.println("doTaskB耗时： " + (System.currentTimeMillis() - beginTime) + "ms");
        }
    }

    public static String doTaskA() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        try {
            Thread.sleep(300);
            List<? extends Serializable> list = Lists.newArrayList("a", sequenceGen.gen(), "doTaskA");
            return JsonUtil.toJsonString(list);
        } finally {
            System.out.println("doTaskA耗时： " + (System.currentTimeMillis() - beginTime) + "ms");
        }
    }
}
