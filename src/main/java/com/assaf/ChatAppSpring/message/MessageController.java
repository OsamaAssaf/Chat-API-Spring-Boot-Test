//package com.assaf.ChatAppSpring.message;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.HtmlUtils;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@RestController
//@RequestMapping("api/v1/chats")
//public class MessageController {
//
//    @MessageMapping("/chats")
//    @SendTo("/topic/messages")
//    public OutputMessage send(@Payload Message message) {
////        Thread.sleep(1000); // simulated delay
//        String time = new SimpleDateFormat("HH:mm").format(new Date());
//        return new OutputMessage(HtmlUtils.htmlEscape(message.getSenderName()) , HtmlUtils.htmlEscape(message.getText()),time);
//    }
//
//}
