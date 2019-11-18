package com.mz.rmq.publisher;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageModel implements Serializable {
    int id;
    String message;
}
