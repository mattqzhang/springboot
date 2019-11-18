package com.mz.rmq.publisher;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessagePublisher {

    @Value("${user.exchange}")
    private String userExchange;
    @Value("${user.routingkey}")
    private String userKey;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void publishToNotification(MessageModel message) {
        String jsonMsg = toJson(message);
        try {
            rabbitTemplate.convertAndSend(userExchange, userKey, jsonMsg);
            log.info("publishing info to rmq: " + jsonMsg);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toJson(MessageModel message) {

        Gson gson = new Gson();
        String jsonStr = gson.toJson(message);

        // restore:
        // MessageModel deserialized = gson.fromJson(jsonStr, MessageModel.class);

        return jsonStr;
    }


}
