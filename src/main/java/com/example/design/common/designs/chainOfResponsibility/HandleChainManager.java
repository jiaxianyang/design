package com.example.design.common.designs.chainOfResponsibility;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * HandleChainManager简介
 * <p>
 * 责任链管理类
 *
 * @author jiaxianyang
 * @date 2022-11-01 19:52
 */
public class HandleChainManager {

    /**
     * 存放责任链路上的具体处理类
     * k-具体业务场景名称
     * v-具体业务场景下的责任链路集合
     */
    private Map<String, List<IHandler>> handleMap;

    public void setHandleMap(List<IHandler> handlerList) {
        handleMap = handlerList
                .stream()
                .sorted(Comparator.comparingInt(h -> AnnotationUtils.findAnnotation(h.getClass(), Duty.class).order()))
                .collect(Collectors.groupingBy(handler -> AnnotationUtils.findAnnotation(handler.getClass(), Duty.class).type()));
    }

    /**
     * 执行具体业务场景中的责任链集合
     * @param type 对应@Duty注解中的type，可以定义为具体业务场景
     * @param t 被执行的参数
     */
    public <T, R> List<R> executeHandle(String type, T t) {
        List<IHandler> handlers = handleMap.get(type);
        List<R> r = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(handlers)) {
            for (IHandler<T, R> handler : handlers) {
                r.add(handler.handle(t));
            }
        }
        return r;
    }
}
