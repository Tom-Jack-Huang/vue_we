package com.hl.vuewe.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserInfo implements Serializable {
    /**
    * 用户ID
    */
    private Integer id;

    /**
    * 用户名
    */
    private String userName;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 手机号
    */
    private String phone;

    /**
    * 密码
    */
    private String password;

    /**
    * qq号
    */
    private String qq;

    private static final long serialVersionUID = 1L;
}