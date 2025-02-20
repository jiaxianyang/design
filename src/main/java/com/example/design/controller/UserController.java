package com.example.design.controller;

import com.example.design.common.base.response.Result;
import com.example.design.spring.event.listener.DemoHandelListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserController简介
 *
 * 用户controller
 * @author jiaxianyang
 * @date 2021-04-24 14:04
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Resource
    private DemoHandelListener demoHandelListener;

    @GetMapping("name")
    public Result<String> queryUserName() {
        return Result.succeed("jiaxianyang");
    }

    @GetMapping("values")
    public Result<List<String>> queryValues(Long id) {
        return Result.succeed(demoHandelListener.getValueList(id));
    }
}
