package com.praveen.notification_consumer.consumer;

import com.praveen.notification_consumer.controller.WebSocketController;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private final WebSocketController webSocketController;

    public MessageConsumer(WebSocketController webSocketController) {
        this.webSocketController = webSocketController;
    }

    @RabbitListener(queues = "notification_queue")
    public void consumeMessage(String message) {
        System.out.println("Received Message from RabbitMQ: " + message);
        // Broadcast the message to WebSocket subscribers
        webSocketController.broadcastMessage(message);
    }
}