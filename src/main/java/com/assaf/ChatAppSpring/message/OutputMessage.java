package com.assaf.ChatAppSpring.message;

import lombok.Data;

@Data
public class OutputMessage {
    private String text;
    private String senderName;
    private String time;

    public OutputMessage(String text, String senderName, String time) {
        this.text = text;
        this.senderName = senderName;
        this.time = time;
    }
}
