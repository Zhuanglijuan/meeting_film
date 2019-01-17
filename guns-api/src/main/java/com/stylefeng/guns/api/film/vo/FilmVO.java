package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: zhuanglj
 * @create: 2019-01-16 17:44
 */
@Data
public class FilmVO implements Serializable {
    private int filmNum;

    private List<FilmInfo> filmInfo;
}
