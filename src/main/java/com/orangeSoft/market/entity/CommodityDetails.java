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
public class CommodityDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "details_id", type = IdType.AUTO)
    private Long detailsId;

    private Long cid;

    private String detailsUrl;


}
