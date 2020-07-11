package com.hl.vuewe.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserInfo implements Serializable {
    /**
    * 用户ID
    */
    public Integer id;

    /**
    * 用户名
    */
    public String userName;

    /**
    * 邮箱
    */
    public String email;

    /**
    * 手机号
    */
    public String phone;

    /**
    * 密码
    */
    public String password;

    /**
    * qq号
    */
    public String qq;

    private static final long serialVersionUID = 1L;
}