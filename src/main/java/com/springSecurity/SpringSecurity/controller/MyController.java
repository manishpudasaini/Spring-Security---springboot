package com.springSecurity.SpringSecurity.controller;

import com.springSecurity.SpringSecurity.entity.UserInfo;
import com.springSecurity.SpringSecurity.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MyController {
    private final UserService userService;

    public MyController(UserService userService) {
        this.userService = userService;

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


}
