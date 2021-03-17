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
public class SubCommodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sub_id", type = IdType.AUTO)
    private Integer subId;

    //    @TableId(value = "cid")
    private Long cid;

    private String subName;

    private String subIcon;

    private Integer stock;

    private Double price;

    private Boolean subCommodityStatus;

}
