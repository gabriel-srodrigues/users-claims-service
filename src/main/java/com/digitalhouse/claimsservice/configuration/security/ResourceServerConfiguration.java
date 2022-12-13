package com.digitalhouse.claimsservice.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfiguration {

    @Bean
    public SecurityFilterChain springFilterChain(HttpSecurity httpSecurity) throws Exception {

            httpSecurity
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
                .and()
                .csrf().disable();

        httpSecurity.oauth2ResourceServer()
                .jwt().jwtAuthenticationConverter(new KeycloakJwtConverter());

        return httpSecurity.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder
                .withJwkSetUri("http://localhost:8082/realms/digitalhouse/protocol/openid-connect/certs").build();
    }

}
