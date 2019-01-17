package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-17 10:20
 */
@Data
public class YearVO implements Serializable {
    private String yearId;

    private String yearName;

    private boolean isActive;
}
