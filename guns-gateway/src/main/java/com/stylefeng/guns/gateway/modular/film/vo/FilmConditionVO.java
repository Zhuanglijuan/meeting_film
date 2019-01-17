package com.stylefeng.guns.gateway.modular.film.vo;

import com.stylefeng.guns.api.film.vo.CatVO;
import com.stylefeng.guns.api.film.vo.SourceVO;
import com.stylefeng.guns.api.film.vo.YearVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: zhuanglj
 * @create: 2019-01-17 10:41
 */
@Data
public class FilmConditionVO implements Serializable {
    private List<CatVO> catInfo;

    private List<SourceVO> sourceInfo;

    private List<YearVO> yearInfo;
}
