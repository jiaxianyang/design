package com.example.design.base;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.google.common.collect.Lists;
import java.util.stream.Collectors;

/**
 * @author jiaxianyang
 * @date 2024/11/26 10:24
 */
@ExtendWith(MockitoExtension.class)
class CompletableFutureTest {

    @Test
    void test() throws InterruptedException {
        Runnable task = () -> {
            // 批量任务，需要等待20个都执行完毕
            List<CompletableFuture<String>> futureList = Lists.newArrayList();
            for (int i = 0;i < 20; i++) {
                // 放入未执行的CompletableFuture，result永远为null，模拟未异常关闭的CompletableFuture
                futureList.add(new CompletableFuture<>());
            }
            // 现场代码
            // result永远为null，join操作
            CompletableFuture.allOf(new CompletableFuture[0]).thenApplyAsync(v -> futureList.stream().map(CompletableFuture::join).collect(Collectors.toList()));
        };
        // 模拟300个请求
        for (int i = 0; i < 300; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("usedMemory："+usedMemory);
        while (true) {
            Thread.sleep(10000);
            printThread();
        }
    }

    public void printThread() {
        // 获取根线程组
        ThreadGroup rootThreadGroup = getRootThreadGroup();
        // 估计根线程组中的线程数量
        int estimatedThreadCount = rootThreadGroup.activeCount();
        // 创建一个线程数组来保存线程
        Thread[] threads = new Thread[estimatedThreadCount];
        // 获取根线程组中的线程
        int actualThreadCount = rootThreadGroup.enumerate(threads, true);

        System.out.println("Active threads: " + actualThreadCount);
        for (int i = 0; i < actualThreadCount; i++) {
            System.out.println(threads[i]);
        }
    }

    private ThreadGroup getRootThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup parent;
        while ((parent = threadGroup.getParent()) != null) {
            threadGroup = parent;
        }
        return threadGroup;
    }
}
