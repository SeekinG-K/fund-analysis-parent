package com.scale.message.controller;

import com.scale.invest.api.constant.KafkaConst;
import com.scale.invest.api.dto.socket.SocketStoreInfoDTO;
import com.scale.invest.api.model.InvestStockMain;
import com.scale.invest.api.model.message.InvestMessageTemplate;
import com.scale.invest.api.uitl.JsonFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: IndexController
 * @Description:验证发送消息
 * @author: scale
 * @date: 2018年11月3日 上午9:58:19
 * @Copyright: 863263957@qq.com. All rights reserved.
 */
@RestController
@Slf4j
public class IndexController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 同步发送
     */
    @RequestMapping("/syncSendMessage")
    public <T> String syncSendMessage() {
        InvestMessageTemplate<SocketStoreInfoDTO> messageTemplate = new InvestMessageTemplate<>();
        SocketStoreInfoDTO build = SocketStoreInfoDTO.builder().port("8082").build();
        messageTemplate.setMessageInfo(build);
        String messageTemplateJsonString = JsonFormatUtil.formatJavaObjectToJsonString(messageTemplate);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(KafkaConst.socket_topic,1, null, messageTemplateJsonString);
        kafkaTemplate.send(producerRecord);
        return "success";
    }

    /**
     * 异步发送
     *
     * @return
     */
//    @RequestMapping("/asyncSendMessage")
//    public String sendMessageAsync() {
//        for (int i = 0; i < 100; i++) {
//            /**
//             * <p>
//             * SendResult:如果消息成功写入kafka就会返回一个RecordMetaData对象;result.
//             * getRecordMetadata() 他包含主题信息和分区信息，以及集成在分区里的偏移量。
//             * 查看RecordMetaData属性字段就知道了
//             * </p>
//             *
//             */
//            ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send("kafka-boot", "0", "foo" + i);
//            send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//
//                @Override
//                public void onSuccess(SendResult<String, String> result) {
//                    log.info("async send message success partition [{}]", result.getRecordMetadata().partition());
//                    log.info("async send message success offest[{}]", result.getRecordMetadata().offset());
//                }
//
//                @Override
//                public void onFailure(Throwable ex) {
//                    log.error("async send message fail [{}]", ex.getMessage());
//                }
//            });
//        }
//        return "success";
//    }

}
