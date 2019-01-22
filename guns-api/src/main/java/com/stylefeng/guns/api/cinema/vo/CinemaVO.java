package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-19 15:02
 */
@Data
public class CinemaVO implements Serializable {
    private String uuid;

    private String cinemaName;

    private String address;

    private String minimumPrice;
}
