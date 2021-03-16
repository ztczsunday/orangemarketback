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
        return getJSONResultMap().putLink(SUCCESS, success).putLink(INFORMATION, information).putLink(MESSAGE, message);
    }


    public static JSONResultMap success() {
        return setResultMap(true, "", "");
    }

    public static JSONResultMap success(Object information) {
        return setResultMap(true, information, "");
    }

    public static JSONResultMap success(Object information, String message) {
        return setResultMap(true, information, message);
    }

    public static JSONResultMap fail(Object information) {
        return setResultMap(false, information, "");
    }

    public static JSONResultMap fail() {
        return setResultMap(false, "", "");
    }

    public static JSONResultMap fail(Object information, String message) {
        return setResultMap(false, information, message);
    }


    public static class JSONResultMap extends HashMap<String, Object> {
        private JSONResultMap() {
        }

        public JSONResultMap putLink(String key, Object value) {
            super.put(key, value);
            return this;
        }
    }
}
