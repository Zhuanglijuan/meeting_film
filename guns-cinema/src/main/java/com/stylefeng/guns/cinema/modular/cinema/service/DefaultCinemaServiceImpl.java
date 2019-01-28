package com.stylefeng.guns.cinema.modular.cinema.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.cinema.CinemaServiceAPI;
import com.stylefeng.guns.api.cinema.vo.*;
import com.stylefeng.guns.cinema.common.persistence.dao.*;
import com.stylefeng.guns.cinema.common.persistence.model.MoocAreaDictT;
import com.stylefeng.guns.cinema.common.persistence.model.MoocBrandDictT;
import com.stylefeng.guns.cinema.common.persistence.model.MoocCinemaT;
import com.stylefeng.guns.cinema.common.persistence.model.MoocHallDictT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhuanglj
 * @create: 2019-01-22 09:14
 */
@Component
@Service(interfaceClass = CinemaServiceAPI.class)
public class DefaultCinemaServiceImpl implements CinemaServiceAPI {

    @Autowired
    private MoocAreaDictTMapper moocAreaDictTMapper;

    @Autowired
    private MoocBrandDictTMapper moocBrandDictTMapper;

    @Autowired
    private MoocCinemaTMapper moocCinemaTMapper;

    @Autowired
    private MoocFieldTMapper moocFieldTMapper;

    @Autowired
    private MoocHallDictTMapper moocHallDictTMapper;

    @Autowired
    private MoocHallFilmInfoTMapper moocHallFilmInfoTMapper;

    /**
     * 根据CinemaQueryVO，查询影院列表
     *
     * @param cinemaQueryVO
     * @return
     */
    @Override
    public Page<CinemaVO> getCimemas(CinemaQueryVO cinemaQueryVO) {
        // 判断是否传入查询条件 -> brandId, distId, hallType 是否等于99
        EntityWrapper<MoocCinemaT> entityWrapper = new EntityWrapper<>();
        if (cinemaQueryVO.getBrandId() != 99) {
            entityWrapper.eq("brand_id", cinemaQueryVO.getBrandId());
        }
        if (cinemaQueryVO.getDistrictId() != 99) {
            entityWrapper.eq("area_id", cinemaQueryVO.getDistrictId());
        }
        if (cinemaQueryVO.getHallType() != 99) {
            entityWrapper.like("hall_ids", "%#" + cinemaQueryVO.getHallType() + "#%");
        }

        // 将数据实体转换为业务实体
        Page<MoocCinemaT> page = new Page<>(cinemaQueryVO.getNowPage(), cinemaQueryVO.getPageSize());
        List<MoocCinemaT> moocCinemaTS = moocCinemaTMapper.selectPage(page, entityWrapper);
        // 业务实体集合
        List<CinemaVO> cinemas = new ArrayList<>();
        for (MoocCinemaT moocCinemaT : moocCinemaTS) {
            CinemaVO cinemaVO = new CinemaVO();
            cinemaVO.setUuid(moocCinemaT.getUuid() + "");
            cinemaVO.setMinimumPrice(moocCinemaT.getMinimumPrice() + "");
            cinemaVO.setCinemaName(moocCinemaT.getCinemaName());
            cinemaVO.setAddress(moocCinemaT.getCinemaAddress());
            cinemas.add(cinemaVO);
        }

        // 根据条件判断影院列表总数
        long count = moocCinemaTMapper.selectCount(entityWrapper);

        // 组织返回值对象
        Page<CinemaVO> result = new Page<>();
        result.setRecords(cinemas);
        result.setSize(cinemaQueryVO.getPageSize());
        result.setTotal(count);

        return result;
    }

    @Override
    public List<BrandVO> getBrands(int brandId) {
        boolean flag = false;
        List<BrandVO> brandVOS = new ArrayList<>();
        // 判断传入的brandId是否存在
        MoocBrandDictT moocBrandDictT = moocBrandDictTMapper.selectById(brandId);
        // 判断brandId是否等于99
        if (brandId == 99 || moocBrandDictT == null || moocBrandDictT.getUuid() == null) {
            flag = true;
        }

        // 查询所有列表
        List<MoocBrandDictT> moocBrandDictTS = moocBrandDictTMapper.selectList(null);

        // 判断flag如果为true，则将99置为isActive
        for (MoocBrandDictT brand : moocBrandDictTS) {
            BrandVO brandVO = new BrandVO();
            brandVO.setBrandName(brand.getShowName());
            brandVO.setBrandId(brand.getUuid() + "");
            // 如果flag为true，则需要99即"全部"，flag为false，则匹配brandId置为isActive
            if (flag) {
                if (brand.getUuid() == 99) {
                    brandVO.setActive(true);
                }
            } else {
                if (brand.getUuid() == brandId) {
                    brandVO.setActive(true);
                }
            }
            brandVOS.add(brandVO);
        }
        return brandVOS;
    }

    @Override
    public List<AreaVO> getAreas(int areaId) {
        boolean flag = false;
        List<AreaVO> areaVOS = new ArrayList<>();
        // 判断传入的brandId是否存在
        MoocAreaDictT moocAreaDictT = moocAreaDictTMapper.selectById(areaId);
        // 判断brandId是否等于99
        if (areaId == 99 || moocAreaDictT == null || moocAreaDictT.getUuid() == null) {
            flag = true;
        }

        // 查询所有列表
        List<MoocAreaDictT> moocAreaDictTS = moocAreaDictTMapper.selectList(null);

        // 判断flag如果为true，则将99置为isActive
        for (MoocAreaDictT area : moocAreaDictTS) {
            AreaVO areaVO = new AreaVO();
            areaVO.setAreaName(area.getShowName());
            areaVO.setAreaId(area.getUuid() + "");
            // 如果flag为true，则需要99即"全部"，flag为false，则匹配brandId置为isActive
            if (flag) {
                if (area.getUuid() == 99) {
                    areaVO.setActive(true);
                }
            } else {
                if (area.getUuid() == areaId) {
                    areaVO.setActive(true);
                }
            }
            areaVOS.add(areaVO);
        }
        return areaVOS;
    }

    @Override
    public List<HallTypeVO> getHallTypes(int hallType) {
        boolean flag = false;
        List<HallTypeVO> hallTypeVOS = new ArrayList<>();
        // 判断传入的brandId是否存在
        MoocHallDictT moocHallDictT = moocHallDictTMapper.selectById(hallType);
        // 判断brandId是否等于99
        if (hallType == 99 || moocHallDictT == null || moocHallDictT.getUuid() == null) {
            flag = true;
        }

        // 查询所有列表
        List<MoocHallDictT> moocHallDictTS = moocHallDictTMapper.selectList(null);

        // 判断flag如果为true，则将99置为isActive
        for (MoocHallDictT hall : moocHallDictTS) {
            HallTypeVO hallTypeVO = new HallTypeVO();
            hallTypeVO.setHalltypeName(hall.getShowName());
            hallTypeVO.setHalltypeId(hall.getUuid() + "");
            // 如果flag为true，则需要99即"全部"，flag为false，则匹配brandId置为isActive
            if (flag) {
                if (hall.getUuid() == 99) {
                    hallTypeVO.setActive(true);
                }
            } else {
                if (hall.getUuid() == hallType) {
                    hallTypeVO.setActive(true);
                }
            }
            hallTypeVOS.add(hallTypeVO);
        }
        return hallTypeVOS;
    }

    @Override
    public CinemaInfoVO getCinemaInfoById(int cinemaId) {
        // 数据实体
        MoocCinemaT moocCinemaT = moocCinemaTMapper.selectById(cinemaId);
        // 将数据实体转换成业务实体
        CinemaInfoVO cinemaInfoVO = new CinemaInfoVO();
        cinemaInfoVO.setImgUrl(moocCinemaT.getImgAddress());
        cinemaInfoVO.setCinemaPhone(moocCinemaT.getCinemaPhone());
        cinemaInfoVO.setCinemaName(moocCinemaT.getCinemaName());
        cinemaInfoVO.setCinemaId(moocCinemaT.getUuid() + "");
        cinemaInfoVO.setCinemaAdress(moocCinemaT.getCinemaAddress());
        return cinemaInfoVO;
    }

    @Override
    public List<FilmInfoVO> getFilmInfoByCinemaId(int cinemaId) {
        List<FilmInfoVO> filmInfos = moocFieldTMapper.getFilmInfos(cinemaId);

        return filmInfos;
    }

    @Override
    public FilmFieldVO getFilmFieldInfo(int fieldId) {
        return null;
    }

    @Override
    public FilmInfoVO getFilmInfoByFieldId(int fieldId) {
        return null;
    }
}
