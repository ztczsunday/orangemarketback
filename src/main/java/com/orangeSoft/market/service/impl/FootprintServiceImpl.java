package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Footprint;
import com.orangeSoft.market.mapper.FootprintMapper;
import com.orangeSoft.market.pojo.History;
import com.orangeSoft.market.service.IFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    public IPage<History> findFootPrintByUid(Page<Footprint> page) {
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
        Footprint footprint = new Footprint()
                .setCid(cid)
                .setUid(MySessionUtil.getCurrUser().getUid())
                .setLastBrowserDate(LocalDateTime.now());
        // 判定两行相等的Wrapper
        Wrapper<Footprint> selectWrapper = new QueryWrapper<Footprint>().eq("cid", cid).eq("uid", footprint.getUid());
        // 如果有，则修改；如果没有，则插入
        if (this.getOne(selectWrapper) != null) {
            this.update(footprint, selectWrapper);
        } else {
            this.save(footprint);
        }
        return Result.success();
    }
}
