package com.orangeSoft.market.mapper;

import com.orangeSoft.market.common.pojo.FavoritesCommodityExample;
import com.orangeSoft.market.common.pojo.FavoritesCommodityKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoritesCommodityMapper {
    long countByExample(FavoritesCommodityExample example);

    int deleteByExample(FavoritesCommodityExample example);

    int deleteByPrimaryKey(FavoritesCommodityKey key);

    int insert(FavoritesCommodityKey record);

    int insertSelective(FavoritesCommodityKey record);

    List<FavoritesCommodityKey> selectByExample(FavoritesCommodityExample example);

    int updateByExampleSelective(@Param("record") FavoritesCommodityKey record, @Param("example") FavoritesCommodityExample example);

    int updateByExample(@Param("record") FavoritesCommodityKey record, @Param("example") FavoritesCommodityExample example);
}