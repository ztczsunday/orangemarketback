package com.orangeSoft.market.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ReceiveAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "receive_address_id", type = IdType.AUTO)
    private Integer receiveAddressId;

    private Integer uid;

    private String addressDetails;

    private Boolean isDefault;

    private Boolean isDeleted;
}
