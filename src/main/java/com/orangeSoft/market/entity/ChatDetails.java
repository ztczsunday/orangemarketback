package com.orangeSoft.market.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @since 2021-03-13
 */
@Data
@EqualsAndHashCode
public class ChatDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "chat_content_id", type = IdType.AUTO)
    private Long chatContentId;

    private String chatContent;


}
