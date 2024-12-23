package com.praveen.notification_service.consumer;

import com.praveen.notification_service.dto.NotificationRequest;
import com.praveen.notification_service.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    private final NotificationService notificationService;

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "notification_queue")
    public void consumeNotification(NotificationRequest request) {
        try {
            notificationService.sendNotification(request);
        } catch (Exception e) {
            // Log and let RabbitMQ handle retry through DLX
            throw e;
        }
    }

    @RabbitListener(queues = "notification_retry_queue")
    public void consumeRetryNotification(NotificationRequest request) {
        notificationService.sendNotification(request);
    }
}
