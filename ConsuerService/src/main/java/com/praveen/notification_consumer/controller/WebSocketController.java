package com.praveen.notification_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Method to send messages received from RabbitMQ to WebSocket subscribers
    public void broadcastMessage(String message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
