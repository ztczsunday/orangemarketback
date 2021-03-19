package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.DataDictionary;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IDataDictionaryService extends IService<DataDictionary> {
    /**
     * 查找所有标签
     *
     * @return 标签结果
     */
    Result.JSONResultMap getAllLabels();

    /**
     * 添加新标签
     *
     * @param labelName 新标签名
     * @return 错误提示或者返回新标签对象
     */
    Result.JSONResultMap addNewLabel(String labelName);
}
