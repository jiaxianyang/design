package com.example.design.common.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 * 互斥规则的抽象
 * @author duankaiyuan
 * @date 2021-11-08 16:47 2021-11-08 16:58
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,property = "_class")
public interface Token {
    /**
     * 当前对象是否可以通过校验
     * @param order
     * @return
     */
    boolean match(Object order);

    /**
     * 当前对象的值赋值到token中
     * @param order
     */
    void mix(Object order);

    /**
     * 复制当前token
     * @return
     */
    Token copy();
}
