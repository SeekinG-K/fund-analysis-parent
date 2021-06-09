package com.scale.message.service.impl;

import com.scale.invest.api.constant.KafkaConst;
import com.scale.invest.api.dto.socket.SocketStoreInfoDTO;
import com.scale.message.service.KafkaMessageListenerService;
import com.scale.message.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener extends KafkaMessageListenerService {

    @Autowired
    private RestTemplateService restTemplateService;

    @Override
    @KafkaListener(id = "myListener1", idIsGroup = false, topicPartitions = {@TopicPartition(topic = KafkaConst.socket_topic, partitions = {"0", "1", "2"})})
    public void socketListen(ConsumerRecord<String, String> info) {
        SocketStoreInfoDTO dataType = this.getDataType(info.value(), SocketStoreInfoDTO.class);
        String ip = dataType.getIp();
        String url = "http://" + ip + ":" + dataType.getPort() + "/delete/socket/session";
        restTemplateService.sendRequest(url, dataType);
        log.info(dataType.toString());
    }


    @KafkaListener(id = "myListener2", idIsGroup = false, topicPartitions = {@TopicPartition(topic = KafkaConst.socket_topic, partitions = {"0", "2"})})
    public void socketListen2(ConsumerRecord<String, String> info) {
        log.info("I am myListener2: " + info.value());
    }
}
