package com.orangeSoft.market.utils;

import lombok.Data;

/**
 * 用于返回前端的数据类，默认状态信息success为"SUCCESS"
 *
 * @param <T>返回数据的类型
 */
@Data
public class ResultInfo<T> {
    private String success = "SUCCESS";
    private String msg;
    private T information;
}
