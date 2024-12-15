package com.example.chatroom.service;

import com.google.gson.JsonObject;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketTextHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        JsonObject jsonObject = new JsonObject();
        session.sendMessage(new TextMessage("Hi " + jsonObject.get("user") + " how may we help you?"));
    }
}
