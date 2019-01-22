package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-19 15:09
 */
@Data
public class CinemaInfoVO implements Serializable {
    /**
     * 影院编号
     */
    private String cinemaId;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 影院名称
     */
    private String cinemaName;

    /**
     * 影院地址
     */
    private String cinemaAdress;

    /**
     * 影院联系电话
     */
    private String cinemaPhone;
}
