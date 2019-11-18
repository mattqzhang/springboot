package com.mz.rmq.service;

import com.mz.rmq.model.MessageJsonMeta;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RecvService {

    @RabbitListener(queues = "${user.queuename}")
    public void receiveMessage(MessageJsonMeta message) {
        //log.info("message received .. "+ message);
        try {
            System.out.println("message received .. "+ message);
        }catch (Exception e) {
            //log.info("error while processing message .. ", e);
        }

    }
}
