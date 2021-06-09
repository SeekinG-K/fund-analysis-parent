package com.scale.invest.provider.component.redis;

import com.scale.invest.provider.service.redis.RedisHandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyspaceEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Map;


@Component
@Slf4j
public class RedisKeyEventListener extends KeyspaceEventMessageListener implements ApplicationContextAware {

    private Map<String, RedisHandleService> handleServiceMap;
    public RedisKeyEventListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    protected void doHandleMessage(Message message) {
        String redisKey = message.toString();
        Assert.notEmpty(handleServiceMap, "HandleServiceMap could't be NULL");
        handleServiceMap.forEach((name, redisHandleService) -> {
            if (redisHandleService.shouldDoHandle(redisKey)) {
                redisHandleService.doHandle(redisKey);
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.handleServiceMap = applicationContext.getBeansOfType(RedisHandleService.class);
    }
}
