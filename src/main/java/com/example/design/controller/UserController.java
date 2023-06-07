package com.example.design.controller;

import com.example.design.common.base.response.Result;
import com.example.design.common.entity.Person;
import com.example.design.repo.dao.IPersonDao;
import com.example.design.repo.po.PersonPo;
import com.example.design.repo.po.UserPo;
import com.example.design.spring.event.listener.DemoHandelListener;
import com.example.design.utils.SnowflakeSequenceGen;
import com.example.design.utils.json.JsonUtil;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
@Slf4j
public class UserController {

    @Resource
    private DemoHandelListener demoHandelListener;

    /**
     * ctx容器
     */
    @Resource
    private ApplicationContext applicationContext;

//    @Resource
//    IPersonDao personDao;

    private static SnowflakeSequenceGen sequenceGen = new SnowflakeSequenceGen(1, 1);

    /**
     * loadingCache
     */
    private LoadingCache<String, String> loadingCache = Caffeine.newBuilder()
            .initialCapacity(100000)
            .maximumSize(2000000000000000000L)
            .refreshAfterWrite(1000, TimeUnit.SECONDS)
            .removalListener((key, value, cause)
                    -> log.debug("缓存被移除 key{},value{}", key, value))
            .build(
                    new CacheLoader<String, String>() {
                        @Override
                        public @Nullable String load(@NonNull String key) throws Exception {
                            return doLoad();
                        }

                        @Override
                        public @Nullable String reload(@NonNull String key, @NonNull String oldValue) throws Exception {
                            return doLoad();
                        }
                    }
            );

    private String doLoad() {
        return String.valueOf(sequenceGen.gen());
    }

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

    @GetMapping("/info/{id}")
    @ResponseBody
    public Result<Person> queryUserInfo(@PathVariable Long id) {
        Person person = new Person();
        person.setId(id);
        person.setName(sequenceGen.gen() + "");
//        Random random = new Random();
//        int randomNumber = random.nextInt(5000000) + 1;
//        PersonPo personPo = personDao.selectPersonById((long)randomNumber);
        return Result.succeed(person);
    }
}
