package com.example.design.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Person简介
 *
 * @author jiaxianyang
 * @date 2021-05-06 15:17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    /**
     * name
     */
    private String name;

    /**
     * age
     */
    private Integer age;

    /**
     * weight 体重
     */
    private BigDecimal weight;

    /**
     * manYn
     */
    private boolean manYn;

    /**
     * sonList
     */
    private List<Son> sonList;

    /**
     * account
     */
    private String account;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
