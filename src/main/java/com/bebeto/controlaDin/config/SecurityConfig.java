package com.bebeto.controlaDin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                    .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                    )
                    .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/controlaDin/incomes", true)
                    )
                    .logout(config -> config
                        .logoutSuccessUrl("/login")
                    )
                    .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                    )
                    .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin())
                    )
                    .build();   
    }
}
