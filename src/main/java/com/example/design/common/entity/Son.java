package com.example.design.common.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Son {
    private Long id;
    private String name;
    private int age;
    private BigDecimal account;
}
