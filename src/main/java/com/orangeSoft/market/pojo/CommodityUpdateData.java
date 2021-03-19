package com.orangeSoft.market.pojo;

import com.orangeSoft.market.entity.CommodityDetails;
import com.orangeSoft.market.entity.CommodityLabel;
import com.orangeSoft.market.entity.CommodityPictures;
import com.orangeSoft.market.entity.SubCommodity;
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
public class CommodityUpdateData {
    private long cid;
    private String commodityName;
    private String mainIcon;
    private boolean commodityStatus;
    private CommodityLabel[] commodityLabels;
    private CommodityPictures[] mainIcons;
    private CommodityDetails[] commodityDetails;
    private SubCommodity[] subCommodity;
}
