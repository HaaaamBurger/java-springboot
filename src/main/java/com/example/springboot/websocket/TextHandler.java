package com.example.springboot.websocket;

import com.example.springboot.dto.ReviewDto;
import com.example.springboot.repository.WebSocketRepository;
import com.example.springboot.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class TextHandler extends TextWebSocketHandler {
    private final ReviewService reviewService;
    private final WebSocketRepository webSocketRepository;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        reviewService.saveReview(
                ReviewDto
                        .builder()
                        .title("Title")
                        .comment(message.getPayload())
                        .build()
        );
        webSocketRepository.sendToAll(session.getId(), message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.warn("Connection closed");
        webSocketRepository.removeSession(session.getId());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connection established");
        webSocketRepository.addSession(session);

    }
}
