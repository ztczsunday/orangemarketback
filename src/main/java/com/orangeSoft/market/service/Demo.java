package com.orangeSoft.market.service;

import com.google.gson.Gson;
import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.utils.Result;

/**
 * @author MakiYO
 * @create 2021/3/11
 */
public class Demo {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserSignature("hjggj");
        userInfo.setUserName("hggkj");
        System.out.println(Result.success(userInfo));
        System.out.println(new Gson().toJson(userInfo));
        System.out.println(new Gson().toJson(Result.success(userInfo)));
    }
}
