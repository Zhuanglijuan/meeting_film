package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhuanglj
 * @create: 2019-01-17 10:20
 */
@Data
public class SourceVO implements Serializable {
    private String sourceId;

    private String sourceName;

    private boolean isActive;
}
