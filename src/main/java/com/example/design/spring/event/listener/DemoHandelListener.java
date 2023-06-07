package com.example.design.spring.event.listener;

import com.example.design.common.entity.Person;
import com.example.design.utils.json.JsonUtil;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Slf4j
@Setter
@Component
public class DemoHandelListener {

    private static final int EXPIRE_IN_SECONDS =  1000;

//    @Resource
//    private IUserDao userDao;

    /**
     * loadingCache
     */
    private LoadingCache<String, List<String>> loadingCache = Caffeine.newBuilder()
            .initialCapacity(100000)
            .maximumSize(200000)
            .refreshAfterWrite(EXPIRE_IN_SECONDS, TimeUnit.SECONDS)
            .removalListener((key, value, cause)
                    -> log.debug("缓存被移除 key{},value{}", key, value))
            .build(
                    new CacheLoader<String, List<String>>() {
                        @Override
                        public @Nullable List<String> load(@NonNull String key) throws Exception {
                            return doLoad();
                        }

                        @Override
                        public @Nullable List<String> reload(@NonNull String key, @NonNull List<String> oldValue) throws Exception {
                            return doLoad();
                        }
                    }
            );


    private List<String> doLoad() {
        return Lists.newArrayList();
    }

    private static final ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    private static final CopyOnWriteArrayList<Person> copyOnWriteArrayList = new CopyOnWriteArrayList();

    @Async("myExecutor")
    @EventListener(DemoHandleEvent.class)
    public void handleEvent(DemoHandleEvent demoHandleEvent) {
//        Stopwatch started = Stopwatch.createStarted();
        log.info("监听DemoHandleEvent ：" + demoHandleEvent.getClass());
        Preconditions.checkNotNull(demoHandleEvent, "demoHandleEvent is null");
//        log.info("【事件监听】: {}", JsonUtil.toJsonString(demoHandleEvent));
//        while (demoHandleEvent.getId() > 10000000) {
//            log.info("数据量已足够 msgId: {}", demoHandleEvent.getMsgId());
//            return;
//        }
//
//        Random r = new Random();
//
//        UserPo userPo = UserPo.builder()
//                .age(r.nextInt(100))
//                .name(NameUtils.randomName(true, getRandomInt(2, 3)))
//                .userId(demoHandleEvent.getMsgId())
//                .userType(getRandomInt(0, 3))
//                .sex(getRandomInt(0, 1))
//                .content(JsonUtil.toJsonString(demoHandleEvent))
//                .build();
////        userDao.insert(userPo);
//        log.info("事件处理完成 msgId: {} , elapsed: {} ms, value: {}", demoHandleEvent.getMsgId(), started.elapsed(TimeUnit.MILLISECONDS), JsonUtil.toJsonString(demoHandleEvent));
    }


    @EventListener(CreateUserHandleEvent.class)
    public void handleCreateUserHandleEvent(CreateUserHandleEvent createUserHandleEvent) {
        log.info("监听handleCreateUserHandleEvent：" + createUserHandleEvent.getClass());
    }


    @EventListener(CreateUserHandleEvent.class)
    public void handleCreateUserHandleEvent2(CreateUserHandleEvent createUserHandleEvent) {
        log.info("监听handleCreateUserHandleEventv-2：" + createUserHandleEvent.getClass());
        throw new RuntimeException();
    }

    @EventListener(Person.class)
    public void handlePersonHandleEvent(Person person) {
        log.info("监听handleCreateUserHandleEvent：" + person.getClass());
        Long segId = Long.parseLong(person.getName()) % 10000;
        concurrentHashMap.put(person.getName(), JsonUtil.toJsonString(person));
        copyOnWriteArrayList.add(person);
        Map<String, List<Person>> collect = copyOnWriteArrayList.stream().collect(Collectors.groupingBy(Person::getName));

        concurrentHashMap.put(segId + "", JsonUtil.toJsonString(collect));
    }

    @EventListener(Person.class)
    public void handlePersonHandleEvent2(Person person) {
        concurrentHashMap.get(person.getName());
        copyOnWriteArrayList.forEach(p -> p.getId());
    }
//    @EventListener(CommonEvent.class)
//    public void handleCommonEvent(CommonEvent commonEvent) {
//        ApplicationEvent annotation = getAnnotation(commonEvent);
//        log.info("监听：handleCommonEvent" + commonEvent.getClass() + " anotation_value: " + annotation.topicKey());
//    }

    private static ApplicationEvent getAnnotation(Object object) {
        return (ApplicationEvent) AnnotationUtils.findAnnotation(object.getClass(), ApplicationEvent.class);
    }


    public static int getRandomInt(int Min , int Max){
        Random rand = new Random();
        return rand.nextInt(Max - Min + 1) + Min;
    }

    @Bean("myExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(25);
        executor.setMaxPoolSize(25);
        executor.setQueueCapacity(100000);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("listener_");
        executor.initialize();
        return executor;
    }

    public List<String> getValueList(Long id) {
        return loadingCache.get(String.valueOf(id));
    }
}
