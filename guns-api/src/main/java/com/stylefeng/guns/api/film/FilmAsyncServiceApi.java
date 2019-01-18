package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.*;

import java.util.List;

/**
 * @author: zhuanglj
 * @create: 2019-01-16 18:00
 */
public interface FilmAsyncServiceApi {

    /**
     * 获取影片描述信息
     *
     * @param filmId
     * @return
     */
    FilmDescVO getFilmDesc(String filmId);

    /**
     * 获取图片信息
     *
     * @param filmId
     * @return
     */
    ImgVO getImg(String filmId);

    /**
     * 获取导演信息
     *
     * @param filmId
     * @return
     */
    ActorVO getDectInfo(String filmId);

    /**
     * 获取演员信息
     * @param filmId
     * @return
     */
    List<ActorVO> getActors(String filmId);
}
