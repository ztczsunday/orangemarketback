package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.entity.CommodityLabel;
import com.orangeSoft.market.mapper.CommodityLabelMapper;
import com.orangeSoft.market.pojo.CommodityLabelResult;
import com.orangeSoft.market.service.ICommodityLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class CommodityLabelServiceImpl extends ServiceImpl<CommodityLabelMapper, CommodityLabel> implements ICommodityLabelService {
    @Autowired
    DataDictionaryServiceImpl dictionaryService;

    @Override
    public List<CommodityLabel> getLabelsByCid(Long cid) {
        return this.query().eq("cid", cid).list();
    }

    @Override
    public List<CommodityLabelResult> getAllLabels() {
        List<CommodityLabel> labelsId = this.query().list();
        return labelsId.stream().map(label ->
                new CommodityLabelResult(
                        label,
                        dictionaryService.query().eq("record_id", label.getRecordId()).one().getItemName()))
                .collect(Collectors.toList());
    }

    @Override
    public CommodityLabelResult addNewLabel(String labelName) {
        if (dictionaryService.query().eq("item_name", labelName).count() > 0) {
            return null;
        }

        return null;
    }
}
