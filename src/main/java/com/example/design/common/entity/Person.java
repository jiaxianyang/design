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
    private Boolean manYn = false;

    /**
     * sonList
     */
    private List<Son> sonList;

    private List<String> codes;
    private List<String> sonNames;

    /**
     * account
     */
    private String account;

    private Long id;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
