package com.example.springboot.job;

import com.example.springboot.repository.WebSocketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendMessageJob {
    private final WebSocketRepository webSocketRepository;

    @Scheduled(cron = "* * * * * *")
    public void sendMessage() {
        this.webSocketRepository.sendToAll("1", new TextMessage("hello"));
    }
}
