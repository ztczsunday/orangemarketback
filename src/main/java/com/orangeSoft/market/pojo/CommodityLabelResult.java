package com.orangeSoft.market.pojo;

import com.orangeSoft.market.entity.CommodityLabel;
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
public class CommodityLabelResult {
    private static final long serialVersionUID = 1L;

    private Long cid;

    private Long recordId;

    private String labelName;

    public CommodityLabelResult(CommodityLabel commodityLabel, String labelName) {
        this.cid = commodityLabel.getCid();
        this.recordId = commodityLabel.getRecordId();
        this.labelName = labelName;
    }
}
