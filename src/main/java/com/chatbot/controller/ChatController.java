package com.chatbot.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin
public class ChatController {

    private final String RASA_URL = "http://localhost:5005/webhooks/rest/webhook";

    @PostMapping
    public ResponseEntity<String> getBotResponse(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        Map<String, Object> payload = new HashMap<>();
        payload.put("sender", "user");
        payload.put("message", message);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(RASA_URL, entity, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
