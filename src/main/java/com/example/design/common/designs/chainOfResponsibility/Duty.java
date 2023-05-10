package com.example.design.common.designs.chainOfResponsibility;

import org.springframework.stereotype.Service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Service
public @interface Duty {

    /**
     * 标记具体业务场景
     *
     * @return
     */
    String type() default "";

    /**
     * 排序：数值越小，排序越靠前
     *
     * @return
     */
    int order() default 0;
}
