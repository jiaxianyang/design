package com.example.design.repo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPo {
    /**
     * PK
     **/
    private Long id;

    /**
     * User_Id
     **/
    private Long userId;

    /**
     * 用户类型
     **/
    private Integer userType;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;
    private Integer sex;

    /**
     * 密码
     */
    private String password;

    private String content;

    /**
     * 消息时间
     **/
    private Date createdDate;

    /**
     * 消息时间
     **/
    private Date updateDate;
}
