package com.vengeang.springsecurity.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/account","/balance","/loans","/cards").authenticated()
                        .requestMatchers("/notices","/contact","/error").permitAll()
        );

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    UserDetailsService users() {
        UserDetails user = User.withUsername("user").password("{noop}password").authorities("read").build();
        UserDetails admin = User.withUsername("admin").password("{noop}password").authorities("admin").build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
