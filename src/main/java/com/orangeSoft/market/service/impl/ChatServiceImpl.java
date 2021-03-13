package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.entity.Chat;
import com.orangeSoft.market.mapper.ChatMapper;
import com.orangeSoft.market.service.IChatService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任意用户之间，或者店铺之间都能自由私信.	身份只有“用户”和“店铺” 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements IChatService {

}
