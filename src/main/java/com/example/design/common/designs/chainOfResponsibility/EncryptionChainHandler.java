package com.example.design.common.designs.chainOfResponsibility;

import com.example.design.common.Constants.BusinessConstants;
import com.example.design.utils.MD5Utils;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * SignChainHandler简介
 *
 * @author jiaxianyang
 * @date 2022-11-01 20:04
 */
@Duty(type = BusinessConstants.REQUEST, order = 2)
public class EncryptionChainHandler implements IHandler<String, List<String>> {

    @Override
    public List<String> handle(String s) {
        // 加签逻辑
        System.out.println("加密 before: " + s + " , 加密后 after: " + MD5Utils.encode(s));

        return Lists.newArrayList(MD5Utils.encode(s));
    }
}
