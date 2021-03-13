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
public class CommodityPictures implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pictureUrl;

    private Long pid;

    private Long cid;


}
