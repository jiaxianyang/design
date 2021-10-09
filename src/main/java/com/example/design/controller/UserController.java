package com.example.design.controller;

import com.example.design.common.base.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("name")
    public Result<String> queryUserName() {
        return Result.succeed("jiaxianyang");
    }
}
