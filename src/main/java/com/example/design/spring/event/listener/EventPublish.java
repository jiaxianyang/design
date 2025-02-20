package com.example.design.spring.event.listener;

import com.example.design.utils.SnowflakeSequenceGen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
public class EventPublish {

    private final AtomicLong ID = new AtomicLong(0L);

    DateTimeFormatter dfDateTime = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    /**
     * ctx容器
     */
    @Resource
    private ApplicationContext applicationContext;

    private static SnowflakeSequenceGen sequenceGen = new SnowflakeSequenceGen(1, 1);

    @Scheduled(fixedDelay = 1000)
    public void publishDemoEvent() {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    private DemoHandleEvent createEvent() {
        return DemoHandleEvent.builder()
                .eventMsg("event msg: " + dfDateTime.format(LocalDateTime.now()))
                .id(ID.incrementAndGet())
                .msgId(sequenceGen.gen())
                .build();
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setCorePoolSize(25);
        taskExecutor.setMaxPoolSize(25);
        taskExecutor.setQueueCapacity(1000);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        taskExecutor.setThreadFactory(new CustomizableThreadFactory("publish-pool-"));
        return taskExecutor;
    }

    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(ConfigurableListableBeanFactory beanFactory,
                                                                         @Qualifier("taskExecutor") ThreadPoolTaskExecutor taskExecutor) {
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster(beanFactory);
        multicaster.setTaskExecutor(taskExecutor);
        return multicaster;
    }
}
