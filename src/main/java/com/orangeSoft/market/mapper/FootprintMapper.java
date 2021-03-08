package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.Footprint;
import com.orangeSoft.market.pojo.FootprintExample;
import com.orangeSoft.market.pojo.FootprintKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootprintMapper {
    long countByExample(FootprintExample example);

    int deleteByExample(FootprintExample example);

    int deleteByPrimaryKey(FootprintKey key);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    List<Footprint> selectByExample(FootprintExample example);

    Footprint selectByPrimaryKey(FootprintKey key);

    int updateByExampleSelective(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByExample(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);
}