package com.scale.invest.api.model.message;

import com.sun.net.httpserver.Headers;

public class ProducerRecordParam {
    private  String topic;
    private Integer partition;
    private Headers headers;
}
