package com.example.design.base;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogTest {

    /**
     * 正确的打印方式无论info,还是error级别，都放在第最后一个参数上，且不用加占位符，即可打印出详细信息。
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println(1 /0);
        } catch (Exception e) {

            /*=======正确的打印方式========*/
            System.out.println("==========正确的打印方式===========");
            log.error("error: {}", "param", e);
            log.info("info: {}", "param", e);

            System.out.println("==========错误的打印方式: 字符串拼接===========");
            log.error(String.format("error: %s, e: %s", "param", e));
            log.info(String.format("error: %s, e: %s", "param", e));
            System.out.println("==========错误的打印方式: 打印异常堆栈使用占位符, 最后一个占位符无用，只会打印出来占位符===========");
            log.error("error: {}, e: {}", "param", e);
            log.info("error: {}, e: {}", "param", e);
        }
    }
}
