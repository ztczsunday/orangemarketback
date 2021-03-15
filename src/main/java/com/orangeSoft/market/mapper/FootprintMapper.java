package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.Footprint;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface FootprintMapper extends BaseMapper<Footprint> {
    IPage<Commodity> findFootPrintByUid(Integer uid, Page<Footprint> page);
}
