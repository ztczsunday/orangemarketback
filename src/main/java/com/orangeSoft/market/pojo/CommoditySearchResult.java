package com.orangeSoft.market.pojo;

import com.orangeSoft.market.entity.Commodity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
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

    public CommoditySearchResult(Commodity commodity, Double lowestPrice) {
        this.cid = commodity.getCid();
        this.sid = commodity.getSid();
        this.commentCount = commodity.getCommentCount();
        this.commodityName = commodity.getCommodityName();
        this.commodityStatus = commodity.getCommodityStatus();
        this.mainIcon = commodity.getMainIcon();
        this.praiseCommentCount = commodity.getPraiseCommentCount();
        this.lowestPrice = lowestPrice;
    }
}
