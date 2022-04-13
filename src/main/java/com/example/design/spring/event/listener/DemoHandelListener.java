package com.example.design.spring.event.listener;

import com.example.design.utils.json.JsonUtil;
import com.google.common.base.Preconditions;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Slf4j
@Setter
@Component
public class DemoHandelListener {

    @Async("myExecutor")
    @EventListener(DemoHandleEvent.class)
    public void autoWarehouseInsideLessHandle(DemoHandleEvent demoHandleEvent) throws InterruptedException {
        Preconditions.checkNotNull(demoHandleEvent, "demoHandleEvent is null");
        log.info("【事件监听】: {}", JsonUtil.toJsonString(demoHandleEvent));
    }

    @Bean("myExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("listener_");
        executor.initialize();
        return executor;
    }
}
