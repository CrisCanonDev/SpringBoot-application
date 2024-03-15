package com.ccdev.firstWeb.security;

import org.apache.catalina.UserDatabase;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user1 = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$BVEEp0oSWKBf2/rLNhlVsOZogejPMai1qiJqClI9qa4MlgnhSVj1a")
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$BVEEp0oSWKBf2/rLNhlVsOZogejPMai1qiJqClI9qa4MlgnhSVj1a")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/people").permitAll()
                        .requestMatchers("/people/new").hasAnyRole("ADMIN")
                        .requestMatchers("/people/delete/*", "people/edit/*").hasRole("ADMIN")
                        .anyRequest().authenticated() )
                .httpBasic(Customizer.withDefaults())
                .exceptionHandling(ex -> ex.accessDeniedPage("/403"));
        return httpSecurity.build();
    }
}
