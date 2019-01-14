package com.stylefeng.guns.api.user;

/**
 * @Author: zhuanglj
 */
public interface UserAPI {
    /**
     * 登陆
     *
     * @param username :用户名
     * @param password :密码
     * @return
     */
    boolean login(String username, String password);

    /**
     * 注册
     *
     * @param userModel
     * @return
     */
    boolean register(UserModel userModel);

    /**
     * 查询用户信息
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
