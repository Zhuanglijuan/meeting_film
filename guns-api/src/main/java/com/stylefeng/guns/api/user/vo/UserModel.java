package com.stylefeng.guns.api.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-14 19:58
 */
@Data
public class UserModel implements Serializable {
    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

}
