package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.Footprint;
import com.orangeSoft.market.mapper.FootprintMapper;
import com.orangeSoft.market.service.IFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    @Override
    public IPage<Commodity> findFootPrintByUid(Page<Footprint> page) {
        return footprintMapper.findFootPrintByUid(MySessionUtil.getCurrUser().getUid(), page);
    }

    @Override
    public Result.JSONResultMap deleteFootPrint(long cid) {
        QueryWrapper<Footprint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", MySessionUtil.getCurrUser().getUid()).eq("cid", cid);
        if (this.remove(queryWrapper)) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap addFootPrint(long cid) {
        Footprint footprint = new Footprint();
        footprint.setCid(cid);
        footprint.setUid(MySessionUtil.getCurrUser().getUid());
        footprint.setLastBrowserDate(LocalDate.now());
        if (this.save(footprint)) {
            return Result.success();
        }
        return Result.fail();
    }
}
