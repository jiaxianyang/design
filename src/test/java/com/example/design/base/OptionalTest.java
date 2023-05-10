package com.example.design.base;

import com.example.design.common.entity.Person;
import com.example.design.utils.json.JsonUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class OptionalTest {

    @Test
    void testIfPresent() {
        Person person = new Person();
        //有值才执行
        Optional.ofNullable(person.getCodes())
                .ifPresent(codeList -> System.out.println(JsonUtil.toJsonString(codeList)));

        person.setCodes(Lists.newArrayList("a", "b", "c", "d"));

        Optional.ofNullable(person.getCodes())
                .ifPresent(codes -> System.out.println(JsonUtil.toJsonString(codes)));
    }

}
