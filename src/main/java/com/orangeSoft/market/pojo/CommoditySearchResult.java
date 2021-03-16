package com.orangeSoft.market.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommoditySearchResult {
    private static final long serialVersionUID = 1L;

    private Long cid;

    private Integer sid;

    private String commodityName;

    private Boolean commodityStatus;

    private String mainIcon;

    private Integer commentCount;

    private Integer praiseCommentCount;

    private Double lowestPrice;
}
