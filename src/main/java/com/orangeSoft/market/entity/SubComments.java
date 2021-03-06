package com.orangeSoft.market.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SubComments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sub_comment_id", type = IdType.AUTO)
    private Long subCommentId;

    private String subCommentDetails;

    private LocalDateTime subCommentTime;

    private Boolean isDeleted;

    private Long commentId;

    private Integer uid;

}
