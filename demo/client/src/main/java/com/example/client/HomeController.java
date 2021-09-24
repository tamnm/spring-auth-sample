package com.example.client;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @RequestMapping("callback")
    public String echo(@RequestParam("code") String code) {
        return code;
    }

    @RequestMapping()
    public Map<String, Object> index(
            Authentication authentication,
            @RegisteredOAuth2AuthorizedClient("Demo-realm") OAuth2AuthorizedClient oauthClient) {
        Map<String, Object> response = new HashMap<>();

        OAuth2User user = (OAuth2User) authentication.getPrincipal();

        response.put("name", user.getName());
        response.put("accessToken", oauthClient.getAccessToken());

        return response;
    }
}
