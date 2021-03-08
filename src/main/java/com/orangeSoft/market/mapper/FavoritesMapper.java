package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.FavoritesExample;
import com.orangeSoft.market.pojo.FavoritesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavoritesMapper {
    long countByExample(FavoritesExample example);

    int deleteByExample(FavoritesExample example);

    int deleteByPrimaryKey(FavoritesKey key);

    int insert(FavoritesKey record);

    int insertSelective(FavoritesKey record);

    List<FavoritesKey> selectByExample(FavoritesExample example);

    int updateByExampleSelective(@Param("record") FavoritesKey record, @Param("example") FavoritesExample example);

    int updateByExample(@Param("record") FavoritesKey record, @Param("example") FavoritesExample example);
}