package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.UserComment;
import com.orangeSoft.market.mapper.CommodityMapper;
import com.orangeSoft.market.mapper.ShopMapper;
import com.orangeSoft.market.mapper.UserCommentMapper;
import com.orangeSoft.market.pojo.UserCommentResult;
import com.orangeSoft.market.service.IUserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class UserCommentServiceImpl extends ServiceImpl<UserCommentMapper, UserComment> implements IUserCommentService {
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    ShopMapper shopMapper;

    @Override
    public Boolean evaluateCommodity(Long cid, String commentDetails, Boolean praise) {
        commodityMapper.updateCommentsCount(cid, praise);
        shopMapper.updateShopCommentsCount(praise);
        return this.save(
                new UserComment()
                        .setUid(MySessionUtil.getCurrUser().getUid())
                        .setCid(cid)
                        .setCommentDetails(commentDetails)
                        .setPraise(praise));
    }

    @Override
    public Result.JSONResultMap getMyAllComments() {
        return Result.success(this.query()
                .eq("uid", MySessionUtil.getCurrUser().getUid())
                .orderByDesc("comment_id").list());
    }

    @Override
    public Result.JSONResultMap getAllCommentsByCid(IPage<UserCommentResult> userCommentIPage, Long cid) {
        return Result.success(this.baseMapper.findAllCommentsByCid(userCommentIPage, cid));
    }
}
