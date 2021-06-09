package com.scale.message.service.impl;

import com.scale.invest.api.uitl.JsonFormatUtil;
import com.scale.message.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 发送请求接口
     *
     * @param url 请求url地址
     * @param requestBody 请求参数体
     */
    @Override
    public <T> void sendRequest(String url, T requestBody) {
        String jsonString = JsonFormatUtil.getJsonString(requestBody);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<>(jsonString, headers);
        String s= restTemplate.postForEntity(url,formEntity,String.class).getBody();
    }
}
