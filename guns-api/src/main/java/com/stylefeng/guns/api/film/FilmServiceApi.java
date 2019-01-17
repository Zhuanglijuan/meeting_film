package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.*;

import java.util.List;

/**
 * @author: zhuanglj
 * @create: 2019-01-16 18:00
 */
public interface FilmServiceApi {
    /**
     * 获取banner信息
     *
     * @return
     */
    List<BannerVO> getBanners();

    /**
     * 获取正在热映的电影
     *
     * @param isLimit
     * @param nums
     * @return
     */
    FilmVO getHotFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    /**
     * 获取经典影片
     *
     * @param nums
     * @param nowPage
     * @param sortId
     * @param sourceId
     * @param yearId
     * @param catId
     * @return
     */
    FilmVO getClassicFilms(int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    /**
     * 获取即将上映的电影[受欢迎程度做排序]
     *
     * @param isLimit :数量要求
     * @param nums    :具体需要的查询的数量
     * @return
     */
    FilmVO getSoonFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    /**
     * 获取票房排行榜
     *
     * @return
     */
    List<FilmInfo> getBoxRanking();

    /**
     * 获取受欢迎的榜单
     *
     * @return
     */
    List<FilmInfo> getExpectRanking();

    /**
     * 获取前一百
     *
     * @return
     */
    List<FilmInfo> getTop();

    // 获取影片条件接口

    /**
     * 分类条件
     *
     * @return
     */
    List<CatVO> getCats();

    /**
     * 片源条件
     *
     * @return
     */
    List<SourceVO> getSources();

    /**
     * 获取年代条件
     *
     * @return
     */
    List<YearVO> getYears();

}
