package com.chatbot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
@CrossOrigin(origins = "*") // Allow all for now; late
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final String RASA_URL = "http://localhost:8090/webhooks/rest/webhook";

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Map<String, String> input) {
        String userMessage = input.get("message");
        String botResponse = sendMessageToRasa(userMessage);
        return ResponseEntity.ok(botResponse);
    }
    @GetMapping("/test")
    public String testEndpoint() {
        return "Chatbot API is running. Use POST /chat/send to talk to Rasa.";
    }


    public String sendMessageToRasa(String userMessage) {
        RestTemplate restTemplate = new RestTemplate();

        // 1. Prepare the JSON body
        Map<String, String> payload = new HashMap<>();
        payload.put("sender", "user123");
        payload.put("message", userMessage);

        // 2. Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 3. Create the request
        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);

        // 4. Send the POST request to Rasa
        ResponseEntity<String> response = restTemplate.postForEntity(
                RASA_URL, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                // 5. Parse the response JSON
                ObjectMapper mapper = new ObjectMapper();
                List<Map<String, Object>> responseList = mapper.readValue(
                        response.getBody(), List.class);

                // 6. Extract all bot responses (in case there are multiple)
                StringBuilder finalReply = new StringBuilder();
                for (Map<String, Object> message : responseList) {
                    if (message.containsKey("text")) {
                        finalReply.append(message.get("text")).append(" ");
                    }
                }
                return finalReply.toString().trim();
            } catch (Exception e) {
                e.printStackTrace();
                return "Error parsing response from Rasa.";
            }
        } else {
            return "Failed to connect to Rasa.";
        }
    }
}