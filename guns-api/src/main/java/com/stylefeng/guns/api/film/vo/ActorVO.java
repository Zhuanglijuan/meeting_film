package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-18 11:27
 */
@Data
public class ActorVO implements Serializable {
    private String imgAddress;

    private String directorName;

    private String roleName;
}
