package com.mz.rmq.controller;

import com.mz.rmq.model.MessageJsonMeta;
import com.mz.rmq.service.PubService;
import com.mz.rmq.service.RecvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RmqMessageController {

    @Autowired
    PubService pubService;

    @Autowired
    RecvService recvService;

    @RequestMapping(value = "/rmqposttest", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> RmqSaveTest(@RequestBody MessageJsonMeta receivedMessage)
            throws IllegalArgumentException, IllegalAccessException {
        try {
            pubService.PublishMessage(receivedMessage);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @RequestMapping(value = "/testfoo", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePath() {
        return "Get some Foos";
    }
}
