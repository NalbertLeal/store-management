package com.nalbertgml.usersmicroservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.nalbertgml.usersmicroservice.models.Message;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RealTimeMessages implements WebSocketHandler {
    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {
        return webSocketSession
            .send(
                webSocketSession.receive()
                    .map(msg -> {
                        Gson gson = new Gson();
                        Message message = gson.fromJson(msg.getPayloadAsText(), Message.class);
                        return "" + message.from + " > " + message.message;
                    })
                    .map(webSocketSession::textMessage)
            );
    }
}
