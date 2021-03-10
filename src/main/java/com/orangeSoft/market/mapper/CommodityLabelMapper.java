package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.CommodityLabelExample;
import com.orangeSoft.market.pojo.CommodityLabelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityLabelMapper {
    long countByExample(CommodityLabelExample example);

    int deleteByExample(CommodityLabelExample example);

    int deleteByPrimaryKey(CommodityLabelKey key);

    int insert(CommodityLabelKey record);

    int insertSelective(CommodityLabelKey record);

    List<CommodityLabelKey> selectByExample(CommodityLabelExample example);

    int updateByExampleSelective(@Param("record") CommodityLabelKey record, @Param("example") CommodityLabelExample example);

    int updateByExample(@Param("record") CommodityLabelKey record, @Param("example") CommodityLabelExample example);
}