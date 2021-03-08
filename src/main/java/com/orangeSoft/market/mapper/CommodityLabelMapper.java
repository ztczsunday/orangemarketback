package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.CommodityLabel;
import com.orangeSoft.market.pojo.CommodityLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityLabelMapper {
    long countByExample(CommodityLabelExample example);

    int deleteByExample(CommodityLabelExample example);

    int deleteByPrimaryKey(Integer labelId);

    int insert(CommodityLabel record);

    int insertSelective(CommodityLabel record);

    List<CommodityLabel> selectByExample(CommodityLabelExample example);

    CommodityLabel selectByPrimaryKey(Integer labelId);

    int updateByExampleSelective(@Param("record") CommodityLabel record, @Param("example") CommodityLabelExample example);

    int updateByExample(@Param("record") CommodityLabel record, @Param("example") CommodityLabelExample example);

    int updateByPrimaryKeySelective(CommodityLabel record);

    int updateByPrimaryKey(CommodityLabel record);
}