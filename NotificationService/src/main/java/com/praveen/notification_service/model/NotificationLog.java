package com.praveen.notification_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notification_logs")
public class NotificationLog {
    @Id
    private String id;
    private String recipientToken;
    private String title;
    private String message;
    private String status; // SUCCESS, FAILURE
    private String errorMessage;
}
