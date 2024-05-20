package com.example.design;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@Slf4j
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class, MybatisAutoConfiguration.class
})
//@MapperScan(basePackages = {"com.example.design.repo.dao"})
public class DesignApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(DesignApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
