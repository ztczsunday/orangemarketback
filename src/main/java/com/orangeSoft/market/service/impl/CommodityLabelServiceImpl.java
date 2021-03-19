package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.entity.CommodityLabel;
import com.orangeSoft.market.mapper.CommodityLabelMapper;
import com.orangeSoft.market.service.ICommodityLabelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class CommodityLabelServiceImpl extends ServiceImpl<CommodityLabelMapper, CommodityLabel> implements ICommodityLabelService {
    @Override
    public List<CommodityLabel> getLabelsByCid(Long cid) {
        return this.query().eq("cid", cid).list();
    }
}
