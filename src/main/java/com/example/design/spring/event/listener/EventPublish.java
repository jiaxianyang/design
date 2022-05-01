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

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent2() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent3() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }
    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent4() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }
    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent5() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }
    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent6() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }
    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent7() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }
    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent8() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }
    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent9() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }
    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent10() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent11() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }


    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent12() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent13() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }


    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent14() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent15() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent16() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent17() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent18() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent19() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent20() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent21() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent22() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent23() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent24() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    @Scheduled(fixedDelay = 100)
    public void publishDemoEvent25() throws InterruptedException {
        DemoHandleEvent event = createEvent();
        applicationContext.publishEvent(event);
    }

    private DemoHandleEvent createEvent() {
        DemoHandleEvent handleEvent = DemoHandleEvent.builder()
                .eventMsg("event msg: " + dfDateTime.format(LocalDateTime.now()))
                .id(ID.incrementAndGet())
                .msgId(sequenceGen.gen())
                .build();
        return handleEvent;
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
