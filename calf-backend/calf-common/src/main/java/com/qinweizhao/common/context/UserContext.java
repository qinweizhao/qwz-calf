package com.qinweizhao.common.context;


import com.qinweizhao.common.util.LoginUser;

/**
 * 用户上下文
 *
 * @author qinweizhao
 */
public class UserContext {

    private static ThreadLocal<LoginUser> userHolder = new ThreadLocal<LoginUser>();

    public static LoginUser getUser() {
        return userHolder.get();
    }

    public static void setUser(LoginUser loginUser) {
        userHolder.set(loginUser);
    }
}
