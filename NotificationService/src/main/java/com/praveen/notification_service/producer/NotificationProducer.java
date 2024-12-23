package com.praveen.notification_service.producer;

import com.praveen.notification_service.dto.NotificationRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNotification(NotificationRequest request) {
        rabbitTemplate.convertAndSend("notification_exchange", "notification_queue", request);
    }
}
