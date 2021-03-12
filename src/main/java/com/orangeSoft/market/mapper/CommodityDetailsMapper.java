package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.CommodityDetails;
import com.orangeSoft.market.pojo.CommodityDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityDetailsMapper {
    long countByExample(CommodityDetailsExample example);

    int deleteByExample(CommodityDetailsExample example);

    int deleteByPrimaryKey(Long detailsId);

    int insert(CommodityDetails record);

    int insertSelective(CommodityDetails record);

    List<CommodityDetails> selectByExample(CommodityDetailsExample example);

    CommodityDetails selectByPrimaryKey(Long detailsId);

    int updateByExampleSelective(@Param("record") CommodityDetails record, @Param("example") CommodityDetailsExample example);

    int updateByExample(@Param("record") CommodityDetails record, @Param("example") CommodityDetailsExample example);

    int updateByPrimaryKeySelective(CommodityDetails record);

    int updateByPrimaryKey(CommodityDetails record);
}