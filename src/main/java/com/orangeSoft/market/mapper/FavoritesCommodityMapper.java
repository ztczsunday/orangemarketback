package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.FavoritesCommodity;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface FavoritesCommodityMapper extends BaseMapper<FavoritesCommodity> {
    IPage<Commodity> findFavoritesCommodityByUid(IPage<Commodity> page, Integer uid);
}
