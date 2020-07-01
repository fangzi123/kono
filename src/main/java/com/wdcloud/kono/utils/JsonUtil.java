package com.wdcloud.kono.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Type;
import java.util.List;


public class JsonUtil {
    /**
     * 校验该串是否为合法的json串
     */
    public static boolean isJsonStr(String jsonStr) {
        if (jsonStr == null)
            return false;
        try {
            JSON.parseObject(jsonStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String toJson(Object src) {
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd hh:mm:ss";
        return JSONObject.toJSONString(src,SerializerFeature.WriteDateUseDateFormat);
    }
    public static String toJsonOnNull(Object src) {
        return JSON.toJSONString(src, SerializerFeature.WRITE_MAP_NULL_FEATURES,SerializerFeature.QuoteFieldNames);
    }
    @SuppressWarnings("unchecked")
    public static <T> T toObject(String src, Class<T> clz) {
        // string 类型特殊处理，不需要json转化
        if (clz == String.class) {
            return (T) src;
        }

        return JSON.parseObject(src, clz);
    }

    public static <T> T toObject(String src, Type clz) {

        return JSON.parseObject(src, clz);
    }

    public static String getJsonValue(String rescontent, String key) {
        JSONObject jsonObject;
        String v = null;

        jsonObject = JSONObject.parseObject(rescontent);
        v = jsonObject.getString(key);

        return v;
    }

    public static <T> List<T> parseArray(String jsonStr, Class<T> clz) {
        return JSON.parseArray(jsonStr, clz);
    }

}
