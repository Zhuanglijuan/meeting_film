package com.stylefeng.guns.gateway.modular.film.vo;

import lombok.Data;

/**
 * @author: zhuanglj
 * @create: 2019-01-17 11:48
 */
@Data
public class FilmRequestVO {
    /**
     * 查询类型，1-正在热映，2-即将上映，3-经典影片
     */
    private Integer showType = 1;

    /**
     * 排序方式，1-按热门搜索，2-按时间搜索，3-按评价搜索
     */
    private Integer sortId = 1;

    /**
     * 类型编号
     */
    private Integer catId = 99;

    /**
     * 区域编号
     */
    private Integer sourceId = 99;

    /**
     * 年代编号
     */
    private Integer yearId = 99;

    /**
     * 影片列表当前页，翻页使用
     */
    private Integer nowPage = 1;

    /**
     * 每页显示条数
     */
    private Integer pageSize = 18;
}
