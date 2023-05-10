package com.example.design.common.designs.chainOfResponsibility;

/**
 * IHandler简介
 *
 * 责任链顶层抽象类
 * @author jiaxianyang
 * @date 2022-11-01 19:50
 */
public interface IHandler<T, R> {

    /**
     * 抽象处理类
     *
     * @param t
     * @return
     */
    R handle(T t);
}
