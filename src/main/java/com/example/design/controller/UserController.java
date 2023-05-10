package com.example.design.controller;

import com.example.design.common.base.response.Result;
import com.example.design.spring.event.listener.DemoHandelListener;
import com.example.design.utils.SnowflakeSequenceGen;
import com.example.design.utils.json.JsonUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * UserController简介
 * <p>
 * 用户controller
 *
 * @author jiaxianyang
 * @date 2021-04-24 14:04
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Resource
    private DemoHandelListener demoHandelListener;

    private static SnowflakeSequenceGen sequenceGen = new SnowflakeSequenceGen(1, 1);

    @GetMapping("name")
    public Result<List<String>> queryUserName() {
        List<String> data = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            data.add(sequenceGen.gen() + "");
        }
        return Result.succeed(data);
    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public Result<String> login(String username, String password) {
        List<String> data = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            data.add(sequenceGen.gen() + "");
        }
        System.out.println("userName : " + username + ", password: " + password);
        return Result.succeed("success");
    }

    @GetMapping("values")
    public Result<List<String>> queryValues(Long id) {
        return Result.succeed(demoHandelListener.getValueList(id));
    }
}
