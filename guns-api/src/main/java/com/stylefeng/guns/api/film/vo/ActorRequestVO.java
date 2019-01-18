package com.stylefeng.guns.api.film.vo;

import com.stylefeng.guns.api.film.vo.ActorVO;
import lombok.Data;

import java.util.List;

/**
 * @author: zhuanglj
 * @create: 2019-01-18 13:36
 */
@Data
public class ActorRequestVO {
    private ActorVO director;

    private List<ActorVO> actors;
}
