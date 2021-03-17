package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.SubComments;
import com.orangeSoft.market.mapper.SubCommentsMapper;
import com.orangeSoft.market.service.ISubCommentsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-16
 */
@Service
public class SubCommentsServiceImpl extends ServiceImpl<SubCommentsMapper, SubComments> implements ISubCommentsService {

    @Override
    public Boolean subEvaluation(SubComments subComments) {
        return this.save(subComments.setIsDeleted(false).setSubCommentTime(null));
    }

    @Override
    public Result.JSONResultMap getSubComments(Long commentId) {
        return Result.success(this.baseMapper.findSubComments(commentId));
    }
}
