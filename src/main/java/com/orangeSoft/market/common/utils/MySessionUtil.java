package com.orangeSoft.market.common.utils;

import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class MySessionUtil {
    private final static String CURRENT_USER = "currUser";
    @Autowired
    private static UserInfoServiceImpl userInfoService;

    public static UserInfo getCurrUser() {
        UserInfo principal = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo currUser = userInfoService.getById(principal.getUid());
        currUser.setUserPassword(principal.getPassword());
        return currUser;
    }

}
