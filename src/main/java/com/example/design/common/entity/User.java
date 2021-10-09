package com.example.design.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * User简介
 *
 * @author jiaxianyang
 * @date 2021-09-27 16:09
 */
@Data
public class User implements Serializable{
//    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;
}
