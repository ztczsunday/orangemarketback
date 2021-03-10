package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.Footprint;
import com.orangeSoft.market.pojo.FootprintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootprintMapper {
    long countByExample(FootprintExample example);

    int deleteByExample(FootprintExample example);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    List<Footprint> selectByExample(FootprintExample example);

    int updateByExampleSelective(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByExample(@Param("record") Footprint record, @Param("example") FootprintExample example);
}