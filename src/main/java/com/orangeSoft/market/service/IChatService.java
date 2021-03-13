package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.entity.Chat;

/**
 * <p>
 * 任意用户之间，或者店铺之间都能自由私信.	身份只有“用户”和“店铺” 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IChatService extends IService<Chat> {

}
