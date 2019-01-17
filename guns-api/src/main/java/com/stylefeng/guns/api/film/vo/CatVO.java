package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-17 10:18
 */
@Data
public class CatVO implements Serializable {
    private String catId;

    private String catName;

    private boolean isActive;
}
