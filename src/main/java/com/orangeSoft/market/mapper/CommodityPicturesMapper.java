package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.CommodityPictures;
import com.orangeSoft.market.pojo.CommodityPicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityPicturesMapper {
    long countByExample(CommodityPicturesExample example);

    int deleteByExample(CommodityPicturesExample example);

    int deleteByPrimaryKey(Long pid);

    int insert(CommodityPictures record);

    int insertSelective(CommodityPictures record);

    List<CommodityPictures> selectByExample(CommodityPicturesExample example);

    CommodityPictures selectByPrimaryKey(Long pid);

    int updateByExampleSelective(@Param("record") CommodityPictures record, @Param("example") CommodityPicturesExample example);

    int updateByExample(@Param("record") CommodityPictures record, @Param("example") CommodityPicturesExample example);

    int updateByPrimaryKeySelective(CommodityPictures record);

    int updateByPrimaryKey(CommodityPictures record);
}