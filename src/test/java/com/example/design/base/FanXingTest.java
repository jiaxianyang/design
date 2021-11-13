package com.example.design.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FanXingTest {

    @Test
    @DisplayName("泛型测试")
    public void test() {
        List list = new ArrayList<>();
        list.add(11);
        list.add("ssss");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String) list.get(i));
        }
    }
}
