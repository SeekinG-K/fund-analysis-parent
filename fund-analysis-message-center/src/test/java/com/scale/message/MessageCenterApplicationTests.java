package com.scale.message;

import com.alibaba.fastjson.JSONObject;
import com.scale.invest.api.dto.socket.SocketStoreInfoDTO;
import com.scale.invest.api.model.InvestStockMain;
import com.scale.invest.api.model.message.InvestMessageTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MessageCenterApplicationTests {
    @Autowired
    private RestTemplate restTemplate;

    @BeforeClass
    public static void runBeforeAllTestMethods() {
    }

    @Test
    void contextLoads() {
        InvestStockMain build = InvestStockMain.builder().id(1L).build();
        InvestMessageTemplate<InvestStockMain> messageTemplate = new InvestMessageTemplate<>();
        messageTemplate.setMessageInfo(build);
        messageTemplate.setDataType(InvestStockMain.class);
        String messageTemplateJsonString = JSONObject.toJSONString(messageTemplate);
        log.info(messageTemplateJsonString);
    }

    @Test
    public void restTemplateTest() {
        String url = "http://127.0.0.1:8082/delete/socket/session";
        JSONObject json = new JSONObject();
        json.put("userId", "4001");
        json.put("ip", "127.0.0.1");
        json.put("port", 8082);
        json.put("connectTime", null);
    }
}
