package com.med_api.InventarioMedfix.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll() // Permitir todas as requisições sem autenticação
                )
                .csrf(csrf -> csrf.disable())  // Desabilitar CSRF
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin())); // Permitir o uso de frames do mesmo domínio (necessário para o H2)

        return http.build();
    }
}
