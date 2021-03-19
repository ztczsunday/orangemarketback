package com.orangeSoft.market.pojo;

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
public class NewCommodityData {
    private String commodityName;
    private String mainIcon;
    private long[] labelId;
    private String[] mainIcons;
    private String[] commodityDetails;
    private SubCommodity[] subCommodity;
}
