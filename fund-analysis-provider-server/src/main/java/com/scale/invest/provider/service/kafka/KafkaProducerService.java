package com.scale.invest.provider.service.kafka;

import com.scale.invest.api.dto.socket.SocketStoreInfoDTO;

public interface KafkaProducerService {

    public void sendMessageToKafka(SocketStoreInfoDTO socketStoreInfoDTO, String redisKey);
}
