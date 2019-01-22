package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-18 16:23
 */
@Data
public class CinemaQueryVO implements Serializable {
    private Integer brandId = 99;

    private Integer hallType = 99;

    private Integer districtId = 99;

    /**
     * 一页显示的数量
     */
    private Integer pageSize = 12;

    /**
     * 当前页数
     */
    private Integer nowPage = 1;
}
