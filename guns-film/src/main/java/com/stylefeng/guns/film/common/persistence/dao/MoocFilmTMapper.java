package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.api.film.vo.FilmDetailVO;
import com.stylefeng.guns.film.common.persistence.model.MoocFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author zhuanglj
 * @since 2019-01-16
 */
@Mapper
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {
    FilmDetailVO getFilmDeatilByName(@Param("filmName") String filmName);

    FilmDetailVO getFilmDeatilById(@Param("uuid") String uuid);
}
