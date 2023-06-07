package com.example.design.repo.po;

import lombok.Data;

import java.util.Date;

@Data
public class PersonPo {
    private Long id;
    private Integer personId;
    private String personName;

    /**
     * 消息时间
     **/
    private Date gmtCreate;

    /**
     * 消息时间
     **/
    private Date gmtModified;
}
