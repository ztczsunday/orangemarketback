package com.orangeSoft.market.common.utils;

import java.util.HashMap;

/**
 * 结果类，用于返回给前端(Json格式)
 */
public class Result {
    private static final String SUCCESS = "success";
    private static final String INFORMATION = "information";
    private static final String MESSAGE = "message";
    private static final ThreadLocal<JSONResultMap> threadLocal = new ThreadLocal<>();

    private Result() {
    }

    private static JSONResultMap getJSONResultMap() {
        JSONResultMap jsonResultMap = threadLocal.get();
        if (jsonResultMap == null) {
            jsonResultMap = new JSONResultMap();
            threadLocal.set(jsonResultMap);
        }
        return jsonResultMap;
    }

    private static JSONResultMap setResultMap(boolean success, Object information, String message) {
        return getJSONResultMap()
                .putLink(SUCCESS, success)
                .putLink(INFORMATION, information)
                .putLink(MESSAGE, information);
    }


    public static JSONResultMap success() {
        return setResultMap(true, "", "");
    }

    public static JSONResultMap success(Object data) {
        return setResultMap(true, data, "");
    }

    public static JSONResultMap success(Object data, String message) {
        return setResultMap(true, data, message);
    }

    public static JSONResultMap fail(Object data) {
        return setResultMap(false, data, "");
    }

    public static JSONResultMap fail() {
        return setResultMap(false, "", "");
    }

    public static JSONResultMap fail(Object data, String message) {
        return setResultMap(false, data, message);
    }


    public static class JSONResultMap extends HashMap<String, Object> {
        private JSONResultMap() {}

        public JSONResultMap putLink(String key, Object value) {
            super.put(key, value);
            return this;
        }
    }
}
