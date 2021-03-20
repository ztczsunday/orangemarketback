package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Chat;
import com.orangeSoft.market.entity.ChatDetails;
import com.orangeSoft.market.entity.Shop;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.mapper.ChatMapper;
import com.orangeSoft.market.pojo.NewChatResult;
import com.orangeSoft.market.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 任意用户之间，或者店铺之间都能自由私信.	身份只有“用户”和“店铺” 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements IChatService {
    @Autowired
    ChatDetailsServiceImpl chatDetailsService;
    @Autowired
    UserInfoServiceImpl userInfoService;
    @Autowired
    ShopServiceImpl shopService;

    @Override
    public Result.JSONResultMap getAboutChats() {
        Integer myId = MySessionUtil.getCurrUser().getUid();
        Set<Integer> contactsId = new HashSet<>();
        List<NewChatResult> chatResults = new ArrayList<>();

        List<Chat> chatsAboutMe = this.query().eq("sender_id", myId).or().eq("receiver_id", myId).orderByDesc("chat_id").list();
        chatsAboutMe.forEach(item -> {
            Integer oppId = item.getReceiverId();
            //false为用户身份，true为商家身份
            boolean oppType = (item.getReceiverType().equals("商家"));
            if (oppId.equals(myId)) {
                oppId = item.getSenderId();
                oppType = item.getSenderType().equals("商家");
            }
            if (!contactsId.contains(oppId)) {
                contactsId.add(oppId);

                if (oppType) {
                    Shop oppShop = shopService.query().eq("uid", oppId).one();
                    chatResults.add(new NewChatResult(item, chatDetailsService.getById(item.getChatContentId()).getChatContent(), oppShop.getShopIcon(), oppShop.getShopName()));
                } else {
                    UserInfo oppUser = userInfoService.getById(oppId);
                    chatResults.add(new NewChatResult(item, chatDetailsService.getById(item.getChatContentId()).getChatContent(), oppUser.getUserSelfie(), oppUser.getTrueUserName()));
                }
            }
        });
        return Result.success(chatResults);
    }

    @Override
    public Result.JSONResultMap getAllChatsWithOpp(Integer oppUid, String oppType) {
        return Result.success(
                this.query()
                        .eq("sender_id", oppUid)
                        .eq("sender_type", oppType)
                        .or()
                        .eq("receiver_id", oppUid)
                        .eq("receiver_type", oppType).list());
    }

    @Override
    public Result.JSONResultMap sendChat(String myType, Integer oppUid, Integer oppSid, String chatContent) {
        ChatDetails chatDetails = new ChatDetails(null, chatContent);
        chatDetailsService.save(chatDetails);
        String oppType = "用户";
        if (oppUid == null) {
            oppUid = shopService.getById(oppSid).getUid();
            oppType = "商家";
        }
        this.save(new Chat(null, chatDetails.getChatContentId(), null, MySessionUtil.getCurrUser().getUid(), myType, oppUid, oppType, false));
        return Result.success();
    }
}
