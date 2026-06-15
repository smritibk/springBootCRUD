package com.nchl.projectcrudoperation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(
//                auth -> auth.anyRequest().
//                        permitAll()
//        ).formLogin(Customizer.withDefaults());

        httpSecurity.authorizeHttpRequests(
                auth->auth
                        .requestMatchers("/books").permitAll()
                        .requestMatchers("/books/add", "/books/update/**", "/books/delete/**")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .permitAll()
        ).formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin= User.builder().username("admin").password("{noop}password").roles("ADMIN").build();

        UserDetails viewer=User.builder().username("viewer").password("{noop}vpassword").roles("VIEWER").build();
        return new InMemoryUserDetailsManager(admin, viewer);
    }



}
