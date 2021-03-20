package com.orangeSoft.market.pojo;

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
public class UserCommentResult {
    private Long commentId;
    private Integer uid;
    private Boolean praise;
    private LocalDateTime commentTime;
    private String commentDetails;
    private Long cid;
    private String userSelfie;
    private String userName;
    private Integer subCommentCount;
}
