package com.stylefeng.guns.gateway.modular;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserAPI;
import org.springframework.stereotype.Component;

/**
 * @author: zhuanglj
 * @create: 2019-01-14 13:35
 */
@Component
public class Client {
    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    public void run(){
        userAPI.login("admin","password");
    }

}
