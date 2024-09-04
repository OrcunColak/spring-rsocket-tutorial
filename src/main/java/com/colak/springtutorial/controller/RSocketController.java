package com.colak.springtutorial.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class RSocketController {

    @MessageMapping("request-response")
    public Mono<String> requestResponse(String request) {
        return Mono.just("Received request: " + request);
    }

    @MessageMapping("fire-and-forget")
    public Mono<Void> fireAndForget(String request) {
        log.info("Received request: {}", request);
        return Mono.empty();
    }
}
