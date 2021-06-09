package com.scale.invest.provider.service.redis.impl;

import com.scale.invest.api.constant.RedisConst;
import com.scale.invest.provider.service.redis.RedisHandleService;
import org.assertj.core.util.Sets;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WebSocketHandleServiceImpl implements RedisHandleService {

    /**
     * 获取将要处理的Key值
     *
     * @return 返回Key List
     */
    @Override
    public Set<String> getHandleKeyList() {
        Set<String> handleKeySet = Sets.newHashSet();
        handleKeySet.add(RedisConst.webSocketPrefix);
        return handleKeySet;
    }

    /**
     * 判断是否做处理
     *
     * @param messageKey 消息的Key
     * @return 返回true 是该执行器， false不执行handle
     */
    @Override
    public Boolean shouldDoHandle(String messageKey) {
        Set<String> handleKeySet = this.getHandleKeyList();
        for (String handleKey : handleKeySet) {
            if (messageKey.startsWith(handleKey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 执行处理逻辑
     *
     * @param messageKey 消息的Key
     */
    @Override
    public void doHandle(String messageKey) {

    }
}
