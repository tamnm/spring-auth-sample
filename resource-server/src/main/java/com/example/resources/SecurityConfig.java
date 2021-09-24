package com.example.resources;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                    .authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/articles/**")
                            .hasAnyAuthority("SCOPE_article.read")
                        .antMatchers(HttpMethod.POST, "/articles/**")
                            .hasAnyAuthority("SCOPE_article.write")
                        .anyRequest()
                            .authenticated()
                .and()
                    .oauth2ResourceServer()
                        .jwt();
    }
}