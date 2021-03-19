package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.Footprint;
import com.orangeSoft.market.mapper.FootprintMapper;
import com.orangeSoft.market.service.IFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class FootprintServiceImpl extends ServiceImpl<FootprintMapper, Footprint> implements IFootprintService {
    @Autowired
    FootprintMapper footprintMapper;

    public IPage<Commodity> findFootPrintByUid(Page<Footprint> page) {
        return footprintMapper.findFootPrintByUid(MySessionUtil.getCurrUser().getUid(), page);
    }

    @Override
    public boolean addFootPrint(long cid) {
        return this.save(new Footprint(cid, MySessionUtil.getCurrUser().getUid(), null));
    }
}
