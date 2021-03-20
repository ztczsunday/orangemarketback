package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.*;
import com.orangeSoft.market.mapper.*;
import com.orangeSoft.market.pojo.CommoditySearchResult;
import com.orangeSoft.market.pojo.CommodityUpdateData;
import com.orangeSoft.market.pojo.NewCommodityData;
import com.orangeSoft.market.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityDetailsMapper commodityDetailsMapper;
    @Autowired
    private CommodityPicturesMapper commodityPicturesMapper;
    @Autowired
    private SubCommodityMapper subCommodityMapper;
    @Autowired
    private UserCommentMapper userCommentMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private CommodityLabelMapper commodityLabelMapper;
    @Autowired
    private FavoritesCommodityServiceImpl favoritesCommodityService;
    @Autowired
    private ShopServiceImpl shopService;
    @Autowired
    private CommodityLabelServiceImpl commodityLabelService;

    @Override
    public IPage<CommoditySearchResult> findCommodityByKey(Page<CommoditySearchResult> page, String keyword, Double minValue, Double maxValue, String orderColumn) {
        if ("time".equals(orderColumn)) {
            orderColumn = "c.cid desc";
        } else if ("comment".equals(orderColumn)) {
            orderColumn = "(c.praise_comment_count / c.comment_count)";
        } else {
            orderColumn = null;
        }
        return commodityMapper.findByKey(page, keyword, minValue, maxValue, orderColumn);
    }

    @Override
    public IPage<CommoditySearchResult> findCommodityByLabel(Page<CommoditySearchResult> page, String label, Double minValue, Double maxValue, String orderColumn) {
        if ("time".equals(orderColumn)) {
            orderColumn = "c.cid desc";
        } else if ("comment".equals(orderColumn)) {
            orderColumn = "(c.praise_comment_count / c.comment_count) desc";
        } else {
            orderColumn = null;
        }
        return commodityMapper.findByLabel(page, label, minValue, maxValue, orderColumn);
    }

    @Override
    public Result.JSONResultMap getCommodityById(Long commodityId) {
        Map<String, Object> result = new HashMap<>();

        result.put("commodityDetails", commodityDetailsMapper
                .selectList(new QueryWrapper<CommodityDetails>().eq("cid", commodityId)));

        result.put("commodityPictures", commodityPicturesMapper
                .selectList(new QueryWrapper<CommodityPictures>().eq("cid", commodityId)));

        result.put("subCommodity", subCommodityMapper
                .selectList(new QueryWrapper<SubCommodity>().eq("cid", commodityId)));

        result.put("hotComments", userCommentMapper
                .selectList(new QueryWrapper<UserComment>()
                        .eq("cid", commodityId)
                        .orderByDesc("comment_time")
                        .last("limit 3")));

        result.put("isCollected", favoritesCommodityService.isCollected(commodityId));

        Shop shop = shopService.getShopById(this.query().eq("cid", commodityId).one().getSid());
        result.put("shopName", shop.getShopName());
        result.put("shopDescription", shop.getShopDescription());

        return Result.success(result);
    }

    @Override
    public Result.JSONResultMap getCommodityBtSid(IPage<CommoditySearchResult> page, Integer sid) {
        Map<String, IPage<CommoditySearchResult>> rs = new HashMap<>();
        IPage<CommoditySearchResult> commodityOpen = this.baseMapper.findCommodityBySidOpen(page, sid);
        IPage<CommoditySearchResult> commodityClose = this.baseMapper.findCommodityBySidClose(page, sid);
        rs.put("commodityOpen", commodityOpen);
        rs.put("commodityClose", commodityClose);
        return Result.success(rs);
    }

    @Override
    public Result.JSONResultMap recommendCommodities() {
        List<Commodity> footprints = this.query()
                .eq("uid", MySessionUtil.getCurrUser().getUid())
                .orderByDesc("last_browser_date")
                .last("limit 3")
                .list();
        //没有历史浏览记录则直接找10个好评率最高的商品
        if (footprints.size() == 0) {
            return Result.success(this.baseMapper.findNewRecommends());
        }
        List<Commodity> recommends = new ArrayList<>();
        List<List<CommodityLabel>> commodityLabels = footprints.stream()
                .map(item -> commodityLabelService.getLabelsByCid(item.getCid()))
                .collect(Collectors.toList());
        //循环遍历找到的所有历史商品，从其所有标签中随机选取1个搜索好评率最高的10个商品，再从其中随机选取一个
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * commodityLabels.size());
            recommends.add(this.baseMapper
                    .findRecommends(commodityLabels.get(i % footprints.size()).get(index).getCid())
                    .get((int) (Math.random() * 10)));
        }
        return Result.success(recommends);
    }

    @Override
    public Result.JSONResultMap newCommodity(NewCommodityData newCommodityData) {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        Commodity commodity = new Commodity();
        CommodityPictures commodityPictures = new CommodityPictures();
        CommodityDetails commodityDetails = new CommodityDetails();
        CommodityLabel commodityLabel = new CommodityLabel();
        QueryWrapper<Shop> shopQueryWrapper = new QueryWrapper<>();
        Shop shop = shopMapper.selectOne(shopQueryWrapper.eq("uid", userInfo.getUid()));
        commodity.setMainIcon(newCommodityData.getMainIcon());
        commodity.setCommodityName(newCommodityData.getCommodityName());
        commodity.setCommodityStatus(true);
        commodity.setSid(shop.getSid());
        if (commodityMapper.insert(commodity) == 1) {
            for (SubCommodity subCommodity : newCommodityData.getSubCommodity()) {
                subCommodity.setCid(commodity.getCid());
                subCommodity.setSubCommodityStatus(true);
                if (subCommodityMapper.insert(subCommodity) != 1) {
                    return Result.fail();
                }
            }
            for (String mainIcon : newCommodityData.getMainIcons()) {
                commodityPictures.setCid(commodity.getCid());
                commodityPictures.setPictureUrl(mainIcon);
                if (commodityPicturesMapper.insert(commodityPictures) != 1) {
                    return Result.fail();
                }
            }
            for (String commodityDetail : newCommodityData.getCommodityDetails()) {
                commodityDetails.setCid(commodity.getCid());
                commodityDetails.setDetailsUrl(commodityDetail);
                if (commodityDetailsMapper.insert(commodityDetails) != 1) {
                    return Result.fail();
                }
            }
            for (long labelId : newCommodityData.getLabelId()) {
                commodityLabel.setCid(commodity.getCid());
                commodityLabel.setRecordId(labelId);
                if (commodityLabelMapper.insert(commodityLabel) != 1) {
                    return Result.fail();
                }
            }
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap getUpdatedCommodity(long cid) {
        CommodityUpdateData commodityUpdateData = new CommodityUpdateData();
        Commodity commodity = commodityMapper.selectById(cid);
        List<CommodityLabel> commodityLabelList = commodityLabelMapper.selectList(new QueryWrapper<CommodityLabel>().eq("cid", cid));
        List<CommodityPictures> commodityPicturesList = commodityPicturesMapper.selectList(new QueryWrapper<CommodityPictures>().eq("cid", cid));
        List<SubCommodity> subCommodityList = subCommodityMapper.selectList(new QueryWrapper<SubCommodity>().eq("cid", cid));
        List<CommodityDetails> commodityDetailsList = commodityDetailsMapper.selectList(new QueryWrapper<CommodityDetails>().eq("cid", cid));
        commodityUpdateData.setCid(cid);
        commodityUpdateData.setCommodityName(commodity.getCommodityName());
        commodityUpdateData.setCommodityStatus(commodity.getCommodityStatus());
        commodityUpdateData.setMainIcon(commodity.getMainIcon());
        CommodityLabel[] commodityLabels = new CommodityLabel[commodityDetailsList.size()];
        SubCommodity[] subCommodities = new SubCommodity[subCommodityList.size()];
        CommodityPictures[] commodityPictures = new CommodityPictures[commodityPicturesList.size()];
        CommodityDetails[] commodityDetails = new CommodityDetails[commodityDetailsList.size()];
        commodityLabelList.toArray(commodityLabels);
        commodityPicturesList.toArray(commodityPictures);
        subCommodityList.toArray(subCommodities);
        commodityDetailsList.toArray(commodityDetails);
        commodityUpdateData.setCommodityLabels(commodityLabels);
        commodityUpdateData.setMainIcons(commodityPictures);
        commodityUpdateData.setSubCommodity(subCommodities);
        commodityUpdateData.setCommodityDetails(commodityDetails);
        return Result.success(commodityUpdateData);
    }

    @Override
    public Result.JSONResultMap updatedCommodity(CommodityUpdateData commodityUpdateData) {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        Commodity commodity = new Commodity();
        QueryWrapper<CommodityLabel> commodityLabelQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Shop> shopQueryWrapper = new QueryWrapper<>();
        Shop shop = shopMapper.selectOne(shopQueryWrapper.eq("uid", userInfo.getUid()));
        commodity.setCid(commodityUpdateData.getCid());
        commodity.setMainIcon(commodityUpdateData.getMainIcon());
        commodity.setCommodityName(commodityUpdateData.getCommodityName());
        commodity.setCommodityStatus(commodityUpdateData.isCommodityStatus());
        commodity.setSid(shop.getSid());
        if (commodityMapper.updateById(commodity) == 1) {
            for (SubCommodity subCommodity : commodityUpdateData.getSubCommodity()) {
                if (subCommodityMapper.updateById(subCommodity) != 1) {
                    return Result.fail();
                }
            }
            for (CommodityPictures commodityPictures : commodityUpdateData.getMainIcons()) {
                if (commodityPicturesMapper.updateById(commodityPictures) != 1) {
                    return Result.fail();
                }
            }
            for (CommodityDetails commodityDetails : commodityUpdateData.getCommodityDetails()) {
                if (commodityDetailsMapper.updateById(commodityDetails) != 1) {
                    return Result.fail();
                }
            }
            commodityLabelQueryWrapper.eq("cid", commodityUpdateData.getCid());
            commodityLabelMapper.delete(commodityLabelQueryWrapper);
            for (CommodityLabel commodityLabel : commodityUpdateData.getCommodityLabels()) {
                if (commodityLabelMapper.insert(commodityLabel) != 1) {
                    return Result.fail();
                }
            }
            return Result.success();
        }
        return Result.fail();
    }
}