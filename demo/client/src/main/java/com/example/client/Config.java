package com.example.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Configuration
public class Config {

    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2Service(){
        final DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        return (userRequest) -> {
            // Delegate to the default implementation for loading a user
            OAuth2User oidcUser = delegate.loadUser(userRequest);

            return oidcUser;
        };
    }

}
