package com.example.design.common.designs.chainOfResponsibility;

import com.example.design.common.Constants.BusinessConstants;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * SignChainHandler简介
 *
 * @author jiaxianyang
 * @date 2022-11-01 20:04
 */
@Duty(type = BusinessConstants.REQUEST, order = 3)
public class RequestChainHandler implements IHandler<String, List<String>> {

    @Override
    public List<String> handle(String s) {
        // 加签逻辑
        System.out.println("甲方爸爸要求请求");
        return Lists.newArrayList(System.currentTimeMillis() + "");
    }
}
