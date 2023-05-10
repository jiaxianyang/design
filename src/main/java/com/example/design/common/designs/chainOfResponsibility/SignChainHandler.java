package com.example.design.common.designs.chainOfResponsibility;

import com.example.design.common.Constants.BusinessConstants;
import com.example.design.utils.SnowflakeSequenceGen;
import com.example.design.utils.json.JsonUtil;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * SignChainHandler简介
 *
 * @author jiaxianyang
 * @date 2022-11-01 20:04
 */
@Duty(type = BusinessConstants.REQUEST, order = 1)
public class SignChainHandler implements IHandler<String, List<String>> {

    @Override
    public List<String> handle(String s) {
        // 加签逻辑
        System.out.println("甲方爸爸要求加签");
        SnowflakeSequenceGen snowflakeSequenceGen = new SnowflakeSequenceGen(1, 1);
        List<String> ids = Lists.newArrayListWithExpectedSize(1000);
        for (int i = 0; i < 1000; i++) {
            ids.add("SO" + snowflakeSequenceGen.gen());
        }
        return Lists.newArrayList(JsonUtil.toJsonString(ids), s);
    }


    public static void main(String[] args) {
        SnowflakeSequenceGen snowflakeSequenceGen = new SnowflakeSequenceGen(1, 1);
        long gen = snowflakeSequenceGen.gen();
    }
}
