package com.scale.invest.provider;

import com.alibaba.fastjson.JSON;
import com.scale.invest.api.constant.RedisConst;
import com.scale.invest.api.dto.socket.SocketStoreInfoDTO;
import com.scale.invest.provider.component.HostInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProviderServerApplicationTests {

    @Value("${server.port}")
    private Integer serverPort;

    @Autowired
    private HostInfoService hostInfoService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            log.info(address.getHostAddress());
            log.info(serverPort.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String userId = "4001";
        SocketStoreInfoDTO build = SocketStoreInfoDTO.builder()
                .ip(hostInfoService.getServerIp())
                .port(hostInfoService.getServerPort())
                .userId(userId).build();
        String socketStoreInfoDTOJson = JSON.toJSONString(build);
        UUID uuid = UUID.randomUUID();
        Boolean aBoolean = stringRedisTemplate.hasKey(RedisConst.webSocketPrefix + ":" + uuid);
        Object data = stringRedisTemplate.opsForHash().get(RedisConst.webSocketPrefix + ":" + uuid, userId);
        if (Objects.isNull(data)) {
            stringRedisTemplate.opsForHash().put(RedisConst.webSocketPrefix + ":" + uuid, userId, socketStoreInfoDTOJson);
        }
    }
}
