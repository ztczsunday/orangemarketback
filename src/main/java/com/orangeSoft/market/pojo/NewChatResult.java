package com.orangeSoft.market.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.orangeSoft.market.entity.Chat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class NewChatResult {

    private static final long serialVersionUID = 1L;

    @TableId(value = "chat_id", type = IdType.AUTO)
    private Long chatId;

    private Long chatContentId;

    private LocalDateTime chatDate;

    private Integer senderId;

    private String senderType;

    private Integer receiverId;

    private String receiverType;

    private Boolean isRead;

    private String newChatContent;

    private String oppSelfie;

    private String oppName;

    public NewChatResult(Chat chat, String chatContent, String oppSelfie, String oppName) {
        this.chatId = chat.getChatId();
        this.chatContentId = chat.getChatContentId();
        this.chatDate = chat.getChatDate();
        this.senderId = chat.getSenderId();
        this.senderType = chat.getSenderType();
        this.receiverId = chat.getReceiverId();
        this.receiverType = chat.getReceiverType();
        this.isRead = chat.getIsRead();
        this.newChatContent = chatContent;
        this.oppSelfie = oppSelfie;
        this.oppName = oppName;
    }
}