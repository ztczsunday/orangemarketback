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

    @Override
    public Result.JSONResultMap getAboutChats() {
        UserInfo me = MySessionUtil.getCurrUser();
        Set<Contact> contacts = new HashSet<>();
        List<NewChatResult> chatResults = new ArrayList<>();

        List<Chat> chatsAboutMe = this.query()
                .eq("sender_id", me.getUid())
                .or()
                .eq("receiver_id", me.getUid())
                .orderByDesc("chat_id").list();
        chatsAboutMe.forEach(item -> {
            Integer senderId = item.getSenderId();
            /* 填入我的身份、对面的身份 */
            String myType;
            String myName;
            String mySelfie;
            Integer myId = MySessionUtil.getCurrUser().getUid();
            String oppType;
            String oppName;
            String oppSelfie;
            Integer oppId;
            if (myId.equals(item.getReceiverId())) {
                oppId = item.getSenderId();
                oppType = item.getSenderType();
                myType = item.getReceiverType();
            } else {
                oppId = item.getReceiverId();
                oppType = item.getReceiverType();
                myType = item.getSenderType();
            }
            /* 根据我的身份、对面的身份来做初始化 */
            if (myType.equals("商家")) {
                Shop shopInfo = shopService.query().eq("uid", myId).one();
                mySelfie = shopInfo.getShopIcon();
                myName = shopInfo.getShopName();
            } else {
                UserInfo myInfo = MySessionUtil.getCurrUser();
                mySelfie = myInfo.getUserSelfie();
                myName = myInfo.getUsername();
            }
            if (oppType.equals("商家")) {
                Shop shopInfo = shopService.query().eq("uid", oppId).one();
                oppSelfie = shopInfo.getShopIcon();
                oppName = shopInfo.getShopName();
            } else {
                UserInfo oppInfo = userInfoService.getById(oppId);
                oppSelfie = oppInfo.getUserSelfie();
                oppName = oppInfo.getUsername();
            }

            Contact contact = new Contact(oppId, oppType, myType);
            if (!contacts.contains(contact)) {
                contacts.add(contact);

                chatResults.add(new NewChatResult()
                        .setChatDate(item.getChatDate())
                        .setOppId(oppId)
                        .setSenderId(senderId)
                        .setMyType(myType)
                        .setOppType(oppType)
                        .setIsRead(item.getIsRead())
                        .setNewChatContent(chatDetailsService.getById(item.getChatContentId()).getChatContent())
                        .setOppSelfie(oppSelfie)
                        .setOppName(oppName)
                        .setMySelfie(mySelfie)
                        .setMyName(myName));
            }
        });
        return Result.success(chatResults);
    }

    @Override
    public Result.JSONResultMap getAllChatsWithOpp(Integer oppUid, String oppType, String selfType) {
        Integer selfUid = MySessionUtil.getCurrUser().getUid();
        List<Chat> chatList = this.query()
                .eq("sender_id", oppUid)
                .eq("sender_type", oppType)
                .eq("receiver_id", selfUid)
                .eq("receiver_type", selfType)
                .or()
                .eq("receiver_id", oppUid)
                .eq("receiver_type", oppType)
                .eq("sender_id", selfUid)
                .eq("sender_type", selfType)
                .orderByAsc("chat_id")
                .list();
        List<ChatResults> chatResults = chatList.stream().map(chat ->
                new ChatResults(chat.getChatDate(),
                        chatDetailsService.getById(chat.getChatContentId()).getChatContent(),
                        oppUid.equals(chat.getReceiverId()) ? MySessionUtil.getCurrUser().getUid() : oppUid)
        ).collect(Collectors.toList());
        return Result.success(chatResults);
    }

    @Override
    public Result.JSONResultMap sendChat(String myType, Integer oppUid, String oppType, String chatContent) {
        ChatDetails chatDetails = new ChatDetails(null, chatContent);
        chatDetailsService.save(chatDetails);
        this.save(new Chat(null, chatDetails.getChatContentId(), null, MySessionUtil.getCurrUser().getUid(), myType, oppUid, oppType, false));
        return Result.success();
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    private static class Contact {
        public Integer oppId;
        public String oppType;
        public String myType;
    }
}
