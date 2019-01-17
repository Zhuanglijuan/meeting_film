package com.stylefeng.guns.gateway.common;

/**
 * @author: zhuanglj
 * @create: 2019-01-14 20:39
 */
public class CurrentUser {
    // 线程绑定的存储空间
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void saveUserId(String userId) {
        threadLocal.set(userId);
    }

    public static String getCurrentUser() {
        return threadLocal.get();
    }
}
