package com.example.springboot.repository;

import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
@Log
public class WebSocketRepository {

    Map<String, WebSocketSession> sessionMap = new HashMap<>();

    public void addSession(WebSocketSession session) {
        sessionMap.put(session.getId(), session);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void sendToAll(String sessionId, TextMessage message) {
        sessionMap.values().forEach(session -> {
            try {
                session.sendMessage(new TextMessage(message.getPayload()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
