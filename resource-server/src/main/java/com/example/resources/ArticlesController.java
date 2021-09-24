package com.example.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticlesController {

    @GetMapping("/articles")
    public String[] getArticles(Authentication authentication) throws JsonProcessingException {

        var mapper = new ObjectMapper();
        return new String[]{
                "Article 1",
                "Article 2",
                "Article 3"};
    }
}