package com.orangeSoft.market.common.utils;

import com.orangeSoft.market.entity.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;

public class MySessionUtil {
    private final static String CURRENT_USER = "currUser";

    public static UserInfo getCurrUser() {
        return (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
