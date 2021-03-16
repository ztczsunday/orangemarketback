package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.UserInfo;

/**
 * <p>
 * 所有用户 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * @param userInfo 用户信息
     * @return 是否注册完成
     */
    Result.JSONResultMap register(UserInfo userInfo);

    /**
     * @return 当前用户信息
     */
    Result.JSONResultMap findUserInfoByUid();

    /**
     * @param newUserInfo 新的用户信息
     * @return 是否更新完成
     */
    Result.JSONResultMap updateUserInfo(UserInfo newUserInfo);
}
