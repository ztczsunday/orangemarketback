package com.orangeSoft.market.pojo;

import com.orangeSoft.market.entity.Chat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class NewChatResult {
    private LocalDateTime chatDate;
    private Integer oppId;
    private Integer senderId;
    private String myType;
    private String oppType;
    private Boolean isRead;
    private String newChatContent;
    private String oppSelfie;
    private String oppName;
    private String mySelfie;
    private String myName;
}
