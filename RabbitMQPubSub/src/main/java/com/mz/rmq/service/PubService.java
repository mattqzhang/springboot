package com.mz.rmq.service;

import com.mz.rmq.model.MessageJsonMeta;
import com.mz.rmq.publisher.MessageModel;
import com.mz.rmq.publisher.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubService {

    @Autowired
    MessagePublisher publisher;

    private MessageModel buildMessage(MessageJsonMeta meta){
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(meta.getMessage());
        messageModel.setId(meta.getId());
        return messageModel;
    }

    public void PublishMessage(MessageJsonMeta receivedMessage) {
        MessageModel messageModel = buildMessage(receivedMessage);
        System.out.println("message is: " + messageModel.getMessage());
        // publish to RMQ
        try {
            publisher.publishToNotification(messageModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
