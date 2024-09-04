package com.colak.springtutorial.client;

import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RSocketClient {

    private final RSocketRequester requester;

    public RSocketClient(RSocketRequester.Builder builder) {
        this.requester = builder.tcp("localhost", 7000);
    }

    public Mono<String> sendRequestResponse(String message) {
        return requester.route("request-response")
                .data(message)
                .retrieveMono(String.class);
    }

    public Mono<Void> sendFireAndForget(String message) {
        return requester.route("fire-and-forget")
                .data(message)
                .send();
    }
}
