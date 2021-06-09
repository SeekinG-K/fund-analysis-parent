package com.scale.invest.api.model.message;

import com.sun.xml.internal.ws.api.message.Headers;

public class ProducerRecordParam {
    private  String topic;
    private Integer partition;
    private Headers headers;
}
