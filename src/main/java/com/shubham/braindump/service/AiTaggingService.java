package com.shubham.braindump.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.shubham.braindump.entity.Tag;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class AiTaggingService {

    private final WebClient webClient;

    private final Environment env;

    public AiTaggingService(WebClient webClient, Environment env) {
        this.webClient = webClient;
        this.env = env;
    }

    public Tag getTagForThought(String thought) {
        String API_KEY = env.getProperty("GEMINI_API_KEY");
        String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY;
        String prompt = String.format("You are an AI that categorizes short text notes into one of the following categories: [%s].\\n\\nYour task is to choose the **single most appropriate category** for the given note based on its content. \\nDo not return anything else — just return the exact category name.\\n\\nNote: '%s'", Tag.getCommaSeparatedTags(), thought);


        System.out.println(apiUrl);

        System.out.println(prompt);
        Map<String, Object> body = Map.of(
                "contents", List.of(Map.of(
                        "parts", List.of(Map.of("text", prompt))
                ))
        );

        JsonNode response = webClient.post()
                .uri(apiUrl)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        String tag = response.path("candidates")
                .get(0)
                .path("content")
                .path("parts")
                .get(0)
                .path("text")
                .asText()
                .strip();


        return Tag.valueOf(tag);
    }
}
