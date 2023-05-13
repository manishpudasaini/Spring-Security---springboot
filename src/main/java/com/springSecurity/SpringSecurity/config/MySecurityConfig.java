package com.springSecurity.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig  {

    //to encrypt password
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //this bean is used to configure user details
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User
                .withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("NORMAL")
                .build();

        UserDetails adminDetails = User
                .withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();

        //it is used to support inmemory
        return new InMemoryUserDetailsManager(userDetails,adminDetails);

    }

    //this bean is used to configure security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/user/get")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return http.build();
    }




}
