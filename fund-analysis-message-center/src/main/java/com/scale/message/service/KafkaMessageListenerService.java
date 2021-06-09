package com.scale.message.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.scale.invest.api.model.message.InvestMessageTemplate;
import com.scale.invest.api.uitl.JsonFormatUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.util.Assert;

public abstract class KafkaMessageListenerService {

    public void socketListen(ConsumerRecord<String, String> info) {
    }

    public <T> T getDataType(String jsonString, Class<T> tClass) {
        InvestMessageTemplate<T> template = JsonFormatUtil.formatJsonToObject(jsonString, new TypeReference<InvestMessageTemplate<T>>() {});
        Assert.notNull(template, "Can't to get com.scale.invest.api.model.message.InvestMessageTemplate Object");
        JSONObject messageInfo = (JSONObject) template.getMessageInfo();
        return messageInfo.toJavaObject(tClass);
    }


}
