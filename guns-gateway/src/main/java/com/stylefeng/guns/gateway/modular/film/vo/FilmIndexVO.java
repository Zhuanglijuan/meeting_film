package com.stylefeng.guns.gateway.modular.film.vo;

import com.stylefeng.guns.api.film.vo.BannerVO;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.api.film.vo.FilmVO;
import lombok.Data;

import java.util.List;

/**
 * @author: zhuanglj
 * @create: 2019-01-16 17:22
 */
@Data
public class FilmIndexVO {
    /**
     * banner信息
     */
    private List<BannerVO> banners;

    /**
     * 热门电影
     */
    private FilmVO hotFilms;

    /**
     * 即将上映
     */
    private FilmVO soonFilms;

    /**
     * 票房排行榜
     */
    private List<FilmInfo> boxRanking;

    /**
     * 受欢迎的榜单
     */
    private List<FilmInfo> expectRanking;

    /**
     * 前一百
     */
    private List<FilmInfo> top100;
}
