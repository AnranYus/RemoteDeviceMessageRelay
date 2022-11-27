package com.inxtes.remotemessagerelay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class RemoteMessageRelayApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemoteMessageRelayApplication.class, args);
    }

    @Configuration
    static class WebSocketConfig{
        @Bean
        public ServerEndpointExporter serverEndpointExporter() {
            return new ServerEndpointExporter();
        }
    }
}
