package com.stylefeng.guns.gateway.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.gateway.common.CurrentUser;
import com.stylefeng.guns.gateway.modular.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhuanglj
 * @create: 2019-01-15 11:23
 */
@RequestMapping("/user/")
@RestController
public class UserController {
    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    private ResponseVo register(UserModel userModel) {
        if (ToolUtil.isEmpty(userModel.getUsername())) {
            return ResponseVo.serviceFail("用户名不能为空");
        }
        if (ToolUtil.isEmpty(userModel.getPassword())) {
            return ResponseVo.serviceFail("密码不能为空");
        }
        boolean isSuccess = userAPI.register(userModel);
        if (isSuccess) {
            return ResponseVo.success("注册成功");
        } else {
            return ResponseVo.serviceFail("注册失败");
        }
    }

    @RequestMapping(value = "check", method = RequestMethod.POST)
    private ResponseVo check(String username) {
        if (ToolUtil.isNotEmpty(username)) {
            boolean notExists = userAPI.checkUserName(username);
            if (notExists) {
                return ResponseVo.success("用户名不存在");
            } else {
                return ResponseVo.serviceFail("用户名已存在");
            }
        } else {
            return ResponseVo.serviceFail("用户名不能为空");
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    private ResponseVo logout() {
        /**
         * 应用：
         *  1. 前端存储JWT【七天】：JWT的刷新
         *  2. 服务器端会存储活动用户信息【30分钟】
         *  3. JWT的userId为key，查找活跃用户
         * 退出：
         *  1. 前端删除JWT
         *  2. 后端删除活跃用户缓存
         * 现状：
         *  1. 前端删除JWT
         */

        return ResponseVo.success("用户退出成功过");
    }

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    private ResponseVo getUserInfo() {
        // 获取当前登录用户
        String userId = CurrentUser.getCurrentUser();
        if (ToolUtil.isNotEmpty(userId)) {
            //将用户id传入后端进行查询
            int uuid = Integer.parseInt(userId);
            UserInfoModel userInfoModel = userAPI.getUserInfo(uuid);
            if (userInfoModel != null) {
                return ResponseVo.success(userInfoModel);
            } else {
                return ResponseVo.appFail("用户信息查询失败");
            }
        } else {
            return ResponseVo.serviceFail("用户未登录");
        }
    }

    @RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
    private ResponseVo updateUserInfo(UserInfoModel userInfoModel) {
        // 获取当前登录用户
        String userId = CurrentUser.getCurrentUser();
        if (ToolUtil.isNotEmpty(userId)) {
            //将用户id传入后端进行查询
            int uuid = Integer.parseInt(userId);

            //判断当前登录人员的ID与修改的结果ID是否一致
            if (uuid != userInfoModel.getUuid()) {
                return ResponseVo.serviceFail("请修改您个人的信息");
            }
            UserInfoModel userInfo = userAPI.updateUserInfo(userInfoModel);
            if (userInfo != null) {
                return ResponseVo.success(userInfo);
            } else {
                return ResponseVo.appFail("用户信息修改失败");
            }
        } else {
            return ResponseVo.serviceFail("用户未登录");
        }
    }
}
