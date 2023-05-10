package com.example.design.controller;

import com.example.design.common.Constants.BusinessConstants;
import com.example.design.common.designs.chainOfResponsibility.HandleChainManager;
import com.example.design.utils.json.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 往事如风
 * @version 1.0
 * @date 2022/9/6 17:32
 * @description
 */
@RestController
@Slf4j
@RequestMapping("api/test")
public class TestController {

    @Resource
    private HandleChainManager handleChainManager;

    @PostMapping("/send")
    public String duty(@RequestBody String requestBody) {
        List<Object> objects = handleChainManager.executeHandle(BusinessConstants.REQUEST, requestBody);
        return JsonUtil.toJsonString(objects);
    }
}
