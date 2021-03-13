package com.orangeSoft.market.entity;

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
public class CommodityLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cid;

    private Long recordId;


}
