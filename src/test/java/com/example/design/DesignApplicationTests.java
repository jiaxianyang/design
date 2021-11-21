package com.example.design;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignApplicationTests {

    @Test
    void contextLoads() {
        String join = StringUtils.join();
        System.out.println(join);
    }

}
