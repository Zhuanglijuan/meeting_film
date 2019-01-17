package com.stylefeng.guns.gateway.modular.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: zhuanglj
 * @create: 2019-01-14 20:22
 */
@Getter
@Setter
public class ResponseVo<M> {
    /**
     * 返回状态[0-成功, 1-业务失败, 999-表示系统异常]
     */
    private int status;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据实体
     */
    private M data;

    /**
     * 图片前缀
     */
    private String imgPre;

    /**
     * 影片列表当前页
     */
    private int nowPage;

    /**
     * 每页显示条数
     */
    private int totalPage;

    private ResponseVo() {
    }

    /**
     * 成功
     *
     * @param m
     * @param <M>
     * @return
     */
    public static <M> ResponseVo success(M m) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(0);
        responseVo.setData(m);

        return responseVo;
    }

    public static <M> ResponseVo success(int nowPage, int totalPage, String imgPre, M m) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(0);
        responseVo.setData(m);
        responseVo.setImgPre(imgPre);
        responseVo.setTotalPage(totalPage);
        responseVo.setNowPage(nowPage);

        return responseVo;
    }

    /**
     * 成功
     *
     * @param imgPre
     * @param m
     * @param <M>
     * @return
     */
    public static <M> ResponseVo success(String imgPre, M m) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(0);
        responseVo.setData(m);
        responseVo.setImgPre(imgPre);

        return responseVo;
    }

    /**
     * 成功
     *
     * @param msg
     * @param <M>
     * @return
     */
    public static <M> ResponseVo success(String msg) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(0);
        responseVo.setMsg(msg);

        return responseVo;
    }

    /**
     * 业务异常
     *
     * @param msg
     * @param <M>
     * @return
     */
    public static <M> ResponseVo serviceFail(String msg) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(1);
        responseVo.setMsg(msg);

        return responseVo;
    }

    /**
     * 系统异常
     *
     * @param msg
     * @param <M>
     * @return
     */
    public static <M> ResponseVo appFail(String msg) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus(999);
        responseVo.setMsg(msg);

        return responseVo;
    }
}
