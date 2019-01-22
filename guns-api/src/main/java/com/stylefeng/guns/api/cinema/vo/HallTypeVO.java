package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-19 15:04
 */
@Data
public class HallTypeVO implements Serializable {
    private String halltypeId;

    private String halltypeName;

    private boolean isActive;
}
