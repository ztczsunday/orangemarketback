package com.orangeSoft.market.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Result {
    private static final String SUCCESS = "success";
    private static final String INFORMATION = "information";
    private static final String MESSAGE = "message";
    private static ThreadLocal<JSONResultMap> threadLocal = new ThreadLocal<>();

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


    public static JSONResultMap success(Object data) {
        return getJSONResultMap().put(SUCCESS, true).put(INFORMATION, data);
    }

    public static JSONResultMap success(Object data, String message) {
        return getJSONResultMap().put(SUCCESS, true).put(INFORMATION, data).put(MESSAGE, message);
    }

    public static JSONResultMap fail(Object data) {
        return getJSONResultMap().put(SUCCESS, false).put(INFORMATION, data);
    }

    public static JSONResultMap fail(Object data, String message) {
        return getJSONResultMap().put(SUCCESS, false).put(INFORMATION, data).put(MESSAGE, message);
    }


    public static class JSONResultMap implements Map<String, Object> {
        private Map<String, Object> localMap = new HashMap<>();

        private JSONResultMap() {
        }

        private Map<String, Object> getLocalMap() {
            return localMap;
        }

        @Override
        public int size() {
            return getLocalMap().size();
        }

        @Override
        public boolean isEmpty() {
            return getLocalMap().isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
            return getLocalMap().containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return getLocalMap().containsValue(value);
        }

        @Override
        public Object get(Object key) {
            return getLocalMap().get(key);
        }

        @Override
        public JSONResultMap put(String key, Object value) {
            getLocalMap().put(key, value);
            return this;
        }

        @Override
        public Object remove(Object key) {
            return getLocalMap().remove(key);
        }

        @Override
        public void putAll(Map<? extends String, ?> m) {
            getLocalMap().putAll(m);
        }


        @Override
        public void clear() {
            getLocalMap().clear();
        }

        @Override
        public Set<String> keySet() {
            return getLocalMap().keySet();
        }

        @Override
        public Collection<Object> values() {
            return getLocalMap().values();
        }

        @Override
        public Set<Entry<String, Object>> entrySet() {
            return getLocalMap().entrySet();
        }


    }


}
