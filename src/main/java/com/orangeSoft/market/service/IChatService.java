package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Chat;

/**
 * <p>
 * 任意用户之间，或者店铺之间都能自由私信.	身份只有“用户”和“商家” 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IChatService extends IService<Chat> {
    /**
     * 获取所有与我相关的聊天对象以及最新消息
     *
     * @return 结果
     */
    Result.JSONResultMap getAboutChats();

    /**
     * 根据对方用户id获取与对方的所有聊天记录
     *
     * @param oppUid   对方uid
     * @param oppType  对方聊天身份
     * @param selfType 自己的聊天身份
     * @return 结果
     */
    Result.JSONResultMap getAllChatsWithOpp(Integer oppUid, String oppType, String selfType);

    /**
     * 发送私信
     *
     * @param myType      自己的身份
     * @param oppId       对方id，可能是sid或uid
     * @param oppType     对方类型，普通用户或者商家
     * @param chatContent 私信内容
     * @return 结果
     */
    Result.JSONResultMap sendChat(String myType, Integer oppId, String oppType, String chatContent);

}
