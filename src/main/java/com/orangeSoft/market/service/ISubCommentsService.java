package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.entity.SubComments;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-16
 */
public interface ISubCommentsService extends IService<SubComments> {
    /**
     * 追加子评论，并重置设置时间和状态
     *
     * @param subComments 传入子评论对象
     * @return 结果
     */
    Boolean subEvaluation(SubComments subComments);
}
