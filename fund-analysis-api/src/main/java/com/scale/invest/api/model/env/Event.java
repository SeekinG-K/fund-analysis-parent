package com.scale.invest.api.model.env;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
public class Event {

    /**
     * 事件类型
     */
    private String type;

    /**
     * 事件唯一标识
     */
    private String id;

    /**
     * 事件时间
     */
    private Date time;

    /**
     * 事件负载
     */
    private String payloadJson;
    /**
     * 构造方法
     */
    public Event() {
    }

    /**
     * 构造方法
     *
     * @param type
     */
    public Event(String type) {
        this.type = type;
        this.id = UUID.randomUUID().toString();
        this.time = new Date();
    }

    /**
     * 取得事件负载
     *
     * @param clazz
     * @return
     */
    public <T> T getPayload(Class<T> clazz) {
        if (payloadJson != null) {
            return JSON.parseObject(payloadJson, clazz);
        }
        return null;
    }

    /**
     * 取得事件负载
     *
     * @param typeReference
     * @return
     */
    public <T> T getPayload(TypeReference<T> typeReference) {
        if (payloadJson != null) {
            return JSON.parseObject(payloadJson, typeReference);
        }
        return null;
    }

    /**
     * 取得事件负载
     *
     * @param clazz
     * @return
     */
    public <T> T getPayload(Class<T> clazz, T defaultValue) {
        if (payloadJson != null) {
            return JSON.parseObject(payloadJson, clazz);
        }
        return defaultValue;
    }

    /**
     * 取得事件负载
     *
     * @param typeReference
     * @return
     */
    public <T> T getPayload(TypeReference<T> typeReference, T defaultValue) {
        if (payloadJson != null) {
            return JSON.parseObject(payloadJson, typeReference);
        }
        return defaultValue;
    }

    /**
     * @param payload the playload to set
     */
    public void setPayload(Object payload) {
        this.payloadJson = JSON.toJSONString(payload, SerializerFeature.DisableCircularReferenceDetect);
    }
}
