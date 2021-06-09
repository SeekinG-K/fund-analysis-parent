package com.scale.invest.provider.component.socket;

import com.scale.invest.api.constant.RedisConst;
import com.scale.invest.api.dto.socket.SocketStoreInfoDTO;
import com.scale.invest.provider.component.SpringUtil;
import com.scale.invest.provider.component.HostInfoService;
import com.scale.invest.provider.service.kafka.KafkaProducerService;
import com.xiaoleilu.hutool.map.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 前后端交互的类实现消息的接收推送(自己发送给自己)
 * 分布式下，微服务的 WebSocketSession统一管理
 */
@Slf4j
@ServerEndpoint(value = "/fund/provider/socket/{userId}")
@Component
public class WebSocketService {

    private static final AtomicInteger onlineCount = new AtomicInteger(0);
    private final Map<String, WebSocketService> webSocketServiceMap = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        HostInfoService hostInfoService = SpringUtil.getBean(HostInfoService.class);
        KafkaProducerService kafkaProducerService = SpringUtil.getBean(KafkaProducerService.class);
        onlineCount.incrementAndGet(); // 在线数加1
        this.session = session;
        String redisKey = RedisConst.webSocketPrefix + ":" + userId;
        webSocketServiceMap.put(userId, this);
        //查看redis中是否存在该KEY，存在则更新相应的Socket
        SocketStoreInfoDTO build = SocketStoreInfoDTO.builder()
                .ip(hostInfoService.getServerIp())
                .port(hostInfoService.getServerPort())
                .connectTime(new Date())
                .userId(userId).build();
        kafkaProducerService.sendMessageToKafka(build, redisKey);
        log.info("有新连接加入：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
    }

    @OnClose
    public void onClose(Session session) {
        String willCloseSessionId = session.getId();
        onlineCount.decrementAndGet(); // 在线数减1
        webSocketServiceMap.forEach((userIdKey, webSocketServiceKey) -> {
            Session sessionInfo = webSocketServiceKey.session;
            String sessionIdInfo = sessionInfo.getId();
            if (willCloseSessionId.equals(sessionIdInfo)) {

            }
        });
        log.info("有一连接关闭：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("服务端收到客户端[{}]的消息:{}", session.getId(), message);
//        this.sendMessage("Hello, " + message, session);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    public void sendMessageInfo(String message, String userId) {
        WebSocketService webSocketService = webSocketServiceMap.get(userId);
        webSocketService.sendMessage(message);
    }

    private void sendMessage(String message) {
        try {
            log.info("服务端给客户端[{}]发送消息{}", this.session.getId(), message);
            this.session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败：{}", e.getMessage());
        }
    }

    public void deleteLocalSocketSession(SocketStoreInfoDTO socketStoreInfoDTO) {
        StringRedisTemplate stringRedisTemplate = SpringUtil.getBean(StringRedisTemplate.class);
        String userId = socketStoreInfoDTO.getUserId();
        String redisKey = RedisConst.webSocketPrefix + ":" + userId;
        Boolean isExist = stringRedisTemplate.hasKey(redisKey);
        if (MapUtil.isNotEmpty(webSocketServiceMap)) {
            WebSocketService webSocketService = webSocketServiceMap.get(redisKey);
            Session session = webSocketService.session;
            webSocketServiceMap.remove(userId);
        }
        Assert.notNull(isExist, "The redis key is not be null");
        Boolean isDeleteKey = stringRedisTemplate.delete(RedisConst.webSocketPrefix);
        Assert.notNull(isDeleteKey, "The redis key is not be null");
    }
}
