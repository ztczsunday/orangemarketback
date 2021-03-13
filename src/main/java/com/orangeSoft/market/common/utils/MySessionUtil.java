package com.orangeSoft.market.common.utils;

import com.orangeSoft.market.common.pojo.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;

public class MySessionUtil {
    private final static String CURRENT_USER = "currUser";

    public static UserInfo getCurrUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo user = (UserInfo) principal;
        return (UserInfo) principal;
    }

}
