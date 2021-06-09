package com.scale.invest.provider.service.redis;

import java.util.Set;

public interface RedisHandleService {

    /**
     * 获取将要处理的Key值
     *
     * @return 返回Key List
     */
    Set<String> getHandleKeyList();

    /**
     * 判断是否做处理
     *
     * @param messageKey 消息的Key
     * @return 返回true 是该执行器， false不执行handle
     */
    Boolean shouldDoHandle(String messageKey);

    /**
     * 执行处理逻辑
     *
     * @param messageKey 消息的Key
     */
    void doHandle(String messageKey);
}
