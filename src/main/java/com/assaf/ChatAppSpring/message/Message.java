package com.assaf.ChatAppSpring.message;

import lombok.*;

@Getter
@Setter
public class Message {
    private MessageType type;
    private String content;
    private String sender;
}
