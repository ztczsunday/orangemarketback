package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.CommodityLabel;
import com.orangeSoft.market.entity.DataDictionary;
import com.orangeSoft.market.mapper.DataDictionaryMapper;
import com.orangeSoft.market.service.IDataDictionaryService;
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
public class DataDictionaryServiceImpl extends ServiceImpl<DataDictionaryMapper, DataDictionary> implements IDataDictionaryService {

    @Override
    public Result.JSONResultMap getAllLabels() {
        List<CommodityLabel> labelsId = new CommodityLabelServiceImpl().query().list();
        return Result.success(labelsId.stream().map(label ->
                this.query().eq("record_id", label.getRecordId()).one())
                .collect(Collectors.toList()));
    }

    @Override
    public Result.JSONResultMap addNewLabel(String labelName) {
        if (this.query().eq("item_name", labelName).count() > 0) {
            return Result.fail(null, "标签重复！");
        }
        DataDictionary newLabel = new DataDictionary(null, "commodity_label", labelName, null, null);
        this.save(newLabel);
        return Result.success(this.getById(newLabel.getRecordId()));
    }
}
