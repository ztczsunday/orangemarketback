package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Chat;
import com.orangeSoft.market.entity.ChatDetails;
import com.orangeSoft.market.entity.Shop;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.mapper.ChatMapper;
import com.orangeSoft.market.pojo.ChatResults;
import com.orangeSoft.market.pojo.NewChatResult;
import com.orangeSoft.market.service.IChatService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @EqualsAndHashCode
    @AllArgsConstructor
    private static class Contact {
        public Integer oppId;
        public String oppType;
        public String myType;
    }

    @Override
    public Result.JSONResultMap getAboutChats() {
        UserInfo me = MySessionUtil.getCurrUser();
        Set<Contact> contacts = new HashSet<>();
        List<NewChatResult> chatResults = new ArrayList<>();

        List<Chat> chatsAboutMe = this.query().eq("sender_id", me.getUid()).or().eq("receiver_id", me.getUid()).orderByDesc("chat_id").list();
        chatsAboutMe.forEach(item -> {
            Integer oppId = item.getReceiverId();
            //默认对方为接收方
            String oppType = item.getReceiverType();
            String myType = item.getSenderType();
            //如果我是接收方
            if (oppId.equals(me.getUid())) {
                oppId = item.getSenderId();
                oppType = item.getSenderType();
                myType = item.getReceiverType();
            }
            Contact contact = new Contact(oppId, oppType, myType);
            if (!contacts.contains(contact)) {
                contacts.add(contact);

                if (oppType.equals("商家") && myType.equals("用户")) {
                    Shop oppShop = shopService.query().eq("uid", oppId).one();
                    chatResults.add(new NewChatResult(item, chatDetailsService.getById(item.getChatContentId()).getChatContent(), oppShop.getShopIcon(), oppShop.getShopName(), me.getUserSelfie(), me.getUsername()));
                } else if (oppType.equals("用户") && myType.equals("用户")) {
                    UserInfo oppUser = userInfoService.getById(oppId);
                    chatResults.add(new NewChatResult(item, chatDetailsService.getById(item.getChatContentId()).getChatContent(), oppUser.getUserSelfie(), oppUser.getUsername(), me.getUserSelfie(), me.getUsername()));
                } else if (oppType.equals("商家") && myType.equals("商家")) {
                    Shop oppShop = shopService.query().eq("uid", oppId).one();
                    Shop myShop = shopService.query().eq("uid", me.getUid()).one();
                    chatResults.add(new NewChatResult(item, chatDetailsService.getById(item.getChatContentId()).getChatContent(), oppShop.getShopIcon(), oppShop.getShopName(), myShop.getShopIcon(), myShop.getShopName()));
                } else {
                    UserInfo oppUser = userInfoService.getById(oppId);
                    Shop myShop = shopService.query().eq("uid", me.getUid()).one();
                    chatResults.add(new NewChatResult(item, chatDetailsService.getById(item.getChatContentId()).getChatContent(), oppUser.getUserSelfie(), oppUser.getUsername(), myShop.getShopIcon(), myShop.getShopName()));
                }
            }
        });
        return Result.success(chatResults);
    }

    @Override
    public Result.JSONResultMap getAllChatsWithOpp(Integer oppUid, String oppType) {
        List<Chat> chatList = this.query()
                .eq("sender_id", oppUid)
                .eq("sender_type", oppType)
                .or()
                .eq("receiver_id", oppUid)
                .eq("receiver_type", oppType).orderByAsc("chat_id").list();
        List<ChatResults> chatResults = chatList.stream().map(chat ->
                new ChatResults(chat.getChatDate(),
                        chatDetailsService.getById(chat.getChatContentId()).getChatContent(),
                        oppUid.equals(chat.getReceiverId()) ? MySessionUtil.getCurrUser().getUid() : oppUid)
        ).collect(Collectors.toList());
        return Result.success(chatResults);
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
