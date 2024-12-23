package com.praveen.notification_consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    /**
     * Register STOMP endpoints for WebSocket connections.
     * Clients will connect to "/ws" for WebSocket communication.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // WebSocket endpoint
                .setAllowedOrigins("http://localhost:8080") // Allow localhost for backend
                .setAllowedOrigins("http://localhost:3000") // Allow localhost for frontend (if used)
                .withSockJS(); // Enable SockJS fallback for clients that don't support WebSockets
    }

    /**
     * Configure the message broker to handle messages and routing.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Enable in-memory broker with a "/topic" prefix
        config.setApplicationDestinationPrefixes("/app"); // Prefix for messages from clients to the server
    }
}