package com.stylefeng.guns.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserAPI;
import org.springframework.stereotype.Component;

/**
 * @Author: zhuanglj
 */
@Component
@Service(interfaceClass = UserAPI.class)
public class UserImpl implements UserAPI {
    @Override
    public boolean login(String username, String password) {
        System.out.println(username + password);
        return false;
    }
}
