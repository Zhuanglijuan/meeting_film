package com.stylefeng.guns.core.base.tips;

/**
 * 返回给前台的错误提示
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:05:22
 */
public class ErrorTip extends Tip {

    public ErrorTip(int code, String message) {
        super();
        this.status = 999;
        this.msg = "系统出现异常，请联系管理员";
    }
}
