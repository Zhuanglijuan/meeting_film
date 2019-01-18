package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.api.film.vo.ActorVO;
import com.stylefeng.guns.film.common.persistence.model.MoocFilmActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影片与演员映射表 Mapper 接口
 * </p>
 *
 * @author zhuanglj
 * @since 2019-01-18
 */
@Mapper
public interface MoocFilmActorTMapper extends BaseMapper<MoocFilmActorT> {
}
