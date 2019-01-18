package com.stylefeng.guns.api.film.vo;

import com.stylefeng.guns.api.film.vo.ActorRequestVO;
import com.stylefeng.guns.api.film.vo.ImgVO;
import lombok.Data;

/**
 * @author: zhuanglj
 * @create: 2019-01-18 13:38
 */
@Data
public class InfoRequestVO {
    private String biography;

    private ActorRequestVO actors;

    private ImgVO imgs;

    private String filmId;
}
