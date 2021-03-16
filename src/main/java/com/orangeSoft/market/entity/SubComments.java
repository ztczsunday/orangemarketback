package com.orangeSoft.market.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SubComments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sub_comment_id", type = IdType.AUTO)
    private Long subCommentId;

    private String subCommentDetails;

    private LocalDateTime subCommentTime;

    private Integer isDeleted;

    private String commentId;


}
