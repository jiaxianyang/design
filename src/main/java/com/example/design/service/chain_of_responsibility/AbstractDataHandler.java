package com.example.design.service.chain_of_responsibility;

public abstract class AbstractDataHandler<T> {

    // 处理模块化数据
    protected abstract T doRequest(String query) throws Exception;
}
