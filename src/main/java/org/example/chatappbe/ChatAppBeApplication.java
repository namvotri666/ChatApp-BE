package org.example.chatappbe;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class ChatAppBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatAppBeApplication.class, args);
    }
}
