package com.springSecurity.SpringSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureUserController {
    @GetMapping("/user/welcome")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String greeting(){
        return "Hello everyone this is User";
    }
}
