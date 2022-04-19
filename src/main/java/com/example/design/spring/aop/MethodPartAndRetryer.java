package com.example.design.spring.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodPartAndRetryer {
    /**
     * 失败重试次数
     * @return
     */
    int times() default 3;
    /**
     * 失败间隔执行时间 300毫秒
     * @return
     */
    long waitTime() default 300L;
    /**
     * 分片大小
     * @return
     */
    int parts() default 200;
}
