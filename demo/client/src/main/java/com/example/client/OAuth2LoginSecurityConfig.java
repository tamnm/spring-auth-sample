package com.example.client;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->authorizeRequests
                    .antMatchers("/home", "/login**","/callback/", "/webjars/**", "/error**", "/oauth2/authorization/**")
                        .permitAll()
                    .anyRequest()
                        .authenticated())
            .oauth2Login(withDefaults());
    }
}