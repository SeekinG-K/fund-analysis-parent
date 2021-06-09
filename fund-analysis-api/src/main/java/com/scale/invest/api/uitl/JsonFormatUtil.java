package com.scale.invest.api.uitl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class JsonFormatUtil {

    public static <T> T formatJsonToObject(String targetValue, Class<T> tClass) {
        if (!StringUtils.isEmpty(targetValue)) {
            T t = JSONObject.parseObject(targetValue, tClass);
            if (Objects.nonNull(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T formatJsonToObject(String targetValue, TypeReference<T> reference) {
        if (!StringUtils.isEmpty(targetValue)) {
            T t = JSON.parseObject(targetValue, reference);
            if (Objects.nonNull(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T getActualType(JSON json, Class<T> tClass) {
        return JSONObject.toJavaObject(json, tClass);
    }

    public static <T> String formatJavaObjectToJsonString(T object) {
        return JSONObject.toJSONString(object);
    }

    /**
     * Generate Json string
     * @param data JavaObject
     * @param <T> any type
     * @return return json string
     */
    public static <T> String getJsonString(T data) {
        String s = formatJavaObjectToJsonString(data);
        JSONObject json = JSONObject.parseObject(s);
        return json.toString();
    }
}
