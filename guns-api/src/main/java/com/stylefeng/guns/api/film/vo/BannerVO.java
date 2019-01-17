package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-16 17:29
 */
@Data
public class BannerVO implements Serializable {
    private String bannerId;

    private String bannerAddress;

    private String bannerUrl;
}
