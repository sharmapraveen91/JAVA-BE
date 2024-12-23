package com.praveen.notification_service.service;

import com.praveen.notification_service.dto.NotificationRequest;
import com.praveen.notification_service.model.NotificationLog;
import com.praveen.notification_service.repository.NotificationLogRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationLogRepository repository;

    public NotificationService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    public void sendNotification(NotificationRequest request) {
        NotificationLog log = new NotificationLog();
        log.setRecipientToken(request.getRecipientToken());
        log.setTitle(request.getTitle());
        log.setMessage(request.getMessage());

        try {
            // Simulated notification sending logic (e.g., logging or HTTP call)
            logger.info("Sending notification to recipient: {}, Title: {}, Message: {}",
                    request.getRecipientToken(), request.getTitle(), request.getMessage());

            log.setStatus("SUCCESS");
            log.setErrorMessage(null);
        } catch (Exception e) {
            logger.error("Failed to send notification: {}", e.getMessage());
            log.setStatus("FAILURE");
            log.setErrorMessage(e.getMessage());
            throw e;
        } finally {
            repository.save(log);
        }
    }
}
