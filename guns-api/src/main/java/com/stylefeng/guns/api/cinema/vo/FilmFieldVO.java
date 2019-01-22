package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-19 15:17
 */
@Data
public class FilmFieldVO implements Serializable {

    private String fieldId;

    private String beginTime;

    private String endTime;

    private String language;

    private String hallName;

    private String price;

}
