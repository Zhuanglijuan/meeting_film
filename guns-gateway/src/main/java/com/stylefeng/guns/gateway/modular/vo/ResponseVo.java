package com.stylefeng.guns.gateway.modular.vo;

/**
 * @author: zhuanglj
 * @create: 2019-01-14 20:22
 */
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public M getData() {
        return data;
    }

    public void setData(M data) {
        this.data = data;
    }

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
