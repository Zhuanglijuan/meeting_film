package com.stylefeng.guns.film.common.persistence.dao;

import com.stylefeng.guns.api.film.vo.ActorVO;
import com.stylefeng.guns.film.common.persistence.model.MoocActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author zhuanglj
 * @since 2019-01-16
 */
@Mapper
public interface MoocActorTMapper extends BaseMapper<MoocActorT> {
    List<ActorVO> getActors(@Param("filmId") String filmId);
}
