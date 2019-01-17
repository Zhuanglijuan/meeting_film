package com.stylefeng.guns.api.user;

import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserModel;

/**
 * @Author: zhuanglj
 */
public interface UserAPI {
    /**
     * 登陆
     *
     * @param username :用户名
     * @param password :密码
     * @return  :用户id
     */
    int login(String username, String password);

    /**
     * 注册
     *
     * @param userModel
     * @return
     */
    boolean register(UserModel userModel);

    /**
     * 用户名验证
     *
     * @param username
     * @return
     */
    boolean checkUserName(String username);

    /**
     * 获取用户信息
     *
     * @param uuid
     * @return
     */
    UserInfoModel getUserInfo(int uuid);

    /**
     * 更新用户信息
     *
     * @param userInfoModel
     * @return
     */
    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);

}
