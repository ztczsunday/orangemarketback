package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.entity.UserComment;
import com.orangeSoft.market.mapper.UserCommentMapper;
import com.orangeSoft.market.service.IUserCommentService;
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

    @Override
    public Boolean evaluateCommodity(Long cid, String commentDetails, Boolean praise) {
        return this.save(
                new UserComment()
                        .setUid(MySessionUtil.getCurrUser().getUid())
                        .setCid(cid)
                        .setCommentDetails(commentDetails)
                        .setPraise(praise));
    }
}
