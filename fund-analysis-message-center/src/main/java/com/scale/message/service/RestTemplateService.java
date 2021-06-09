package com.scale.message.service;

public interface RestTemplateService {

    /**
     * 发送请求接口
     */
    public <T> void sendRequest(String url, T requestBody);
}
