package com.stylefeng.guns.gateway.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.cinema.CinemaServiceAPI;
import com.stylefeng.guns.api.cinema.vo.CinemaQueryVO;
import com.stylefeng.guns.gateway.modular.vo.ResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: zhuanglj
 * @create: 2019-01-18 16:20
 */
@Controller
@RequestMapping("/cinema/")
public class CinemaController {

    @Reference(interfaceClass = CinemaServiceAPI.class)
    private CinemaServiceAPI cinemaServiceAPI;

    @RequestMapping(value = "getCinemas")
    public ResponseVo getCinemas(CinemaQueryVO cinemaQueryVO) {
        // 按照五个条件进行筛选

        return null;
    }

    @RequestMapping(value = "getCondition")
    public ResponseVo getCondition(CinemaQueryVO cinemaQueryVO) {

        return null;
    }

    @RequestMapping(value = "getFields")
    public ResponseVo getFields(CinemaQueryVO cinemaQueryVO) {

        return null;
    }

    @RequestMapping(value = "getFields")
    public ResponseVo getFields(Integer cinemaId) {

        return null;
    }

    @RequestMapping(value = "getFieldInfo",method = RequestMethod.POST)
    public ResponseVo getFieldInfo(Integer cinemaId, Integer fieldId) {

        return null;
    }
}
