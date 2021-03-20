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
public class SubCommentsResult {
    private Long subCommentId;
    private String subCommentDetails;
    private LocalDateTime subCommentTime;
    private Boolean isDeleted;
    private Long commentId;
    private Integer uid;
    private String userSelfie;
    private String userName;
}
