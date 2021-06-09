package com.scale.invest.provider.service.kafka.impl;

import com.scale.invest.api.constant.KafkaConst;
import com.scale.invest.api.dto.socket.SocketStoreInfoDTO;
import com.scale.invest.api.model.message.InvestMessageTemplate;
import com.scale.invest.api.uitl.JsonFormatUtil;
import com.scale.invest.provider.service.kafka.KafkaProducerService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void sendMessageToKafka(SocketStoreInfoDTO socketStoreInfoDTO, String redisKey) {
        InvestMessageTemplate<SocketStoreInfoDTO> messageTemplate = new InvestMessageTemplate<>();
        String socketStoreInfoDTOJson = JsonFormatUtil.formatJavaObjectToJsonString(socketStoreInfoDTO);
        messageTemplate.setMessageInfo(socketStoreInfoDTO);
        String messageTemplateJsonString = JsonFormatUtil.formatJavaObjectToJsonString(messageTemplate);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(KafkaConst.socket_topic, 1, null, messageTemplateJsonString);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(producerRecord);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @SneakyThrows
            @Override
            public void onFailure(Throwable throwable) {
                throw throwable;
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("success");
                stringRedisTemplate.opsForValue().set(redisKey, socketStoreInfoDTOJson);
            }
        });

    }
}
