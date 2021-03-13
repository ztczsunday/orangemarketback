package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.FavoritesShopExample;
import com.orangeSoft.market.pojo.FavoritesShopKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoritesShopMapper {
    long countByExample(FavoritesShopExample example);

    int deleteByExample(FavoritesShopExample example);

    int deleteByPrimaryKey(FavoritesShopKey key);

    int insert(FavoritesShopKey record);

    int insertSelective(FavoritesShopKey record);

    List<FavoritesShopKey> selectByExample(FavoritesShopExample example);

    int updateByExampleSelective(@Param("record") FavoritesShopKey record, @Param("example") FavoritesShopExample example);

    int updateByExample(@Param("record") FavoritesShopKey record, @Param("example") FavoritesShopExample example);
}