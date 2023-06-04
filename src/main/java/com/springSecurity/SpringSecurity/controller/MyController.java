package com.springSecurity.SpringSecurity.controller;

import com.springSecurity.SpringSecurity.auth.JwtService;
import com.springSecurity.SpringSecurity.entity.AuthRequest;
import com.springSecurity.SpringSecurity.entity.UserInfo;
import com.springSecurity.SpringSecurity.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MyController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public MyController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public String addUser(@RequestBody UserInfo user){
       userService.addUserI(user);
        return "Successfully added";
    }

    @GetMapping("/get")
   public List<UserInfo> getUsers(){
       List<UserInfo> userList= userService.getUsers();
       return userList;
    }

    //this controller is used to create the token and check is user having same username password present in database or not
    @PostMapping("/authenticate")
    public String authenticateUser(AuthRequest authRequest){
        Authentication authenticate =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));

        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(authRequest.getName());
        }else {
            throw new UsernameNotFoundException("User not found");
        }

    }


}
