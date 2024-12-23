package com.praveen.notification_service.dto;


import lombok.Data;

@Data
public class NotificationRequest {
    private String recipientToken;
    private String title;
    private String message;
}