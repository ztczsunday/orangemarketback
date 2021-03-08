package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.CommodityAddLabelExample;
import com.orangeSoft.market.pojo.CommodityAddLabelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityAddLabelMapper {
    long countByExample(CommodityAddLabelExample example);

    int deleteByExample(CommodityAddLabelExample example);

    int deleteByPrimaryKey(CommodityAddLabelKey key);

    int insert(CommodityAddLabelKey record);

    int insertSelective(CommodityAddLabelKey record);

    List<CommodityAddLabelKey> selectByExample(CommodityAddLabelExample example);

    int updateByExampleSelective(@Param("record") CommodityAddLabelKey record, @Param("example") CommodityAddLabelExample example);

    int updateByExample(@Param("record") CommodityAddLabelKey record, @Param("example") CommodityAddLabelExample example);
}