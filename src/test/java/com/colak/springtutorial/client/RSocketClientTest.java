package com.colak.springtutorial.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class RSocketClientTest {

    @Autowired
    private RSocketClient client;

    @Test
    void sendRequestResponse() {
        Mono<String> mono = client.sendRequestResponse("test");
        // Use StepVerifier to verify the Mono
        StepVerifier.create(mono)
                .expectNext("Received request: test") // Check that the next value is "Hello, World!"
                .verifyComplete(); // Check that the Mono completes successfully
    }

    @Test
    void sendFireAndForget() {
        Mono<Void> mono = client.sendFireAndForget("test");
        // Use StepVerifier to verify the Mono
        StepVerifier.create(mono)
                .verifyComplete(); // Check that the Mono completes successfully without emitting any values
    }
}