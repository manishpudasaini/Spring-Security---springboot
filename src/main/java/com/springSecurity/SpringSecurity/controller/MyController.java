package com.springSecurity.SpringSecurity.controller;

import com.springSecurity.SpringSecurity.entity.User;
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
    public String addUser(@RequestBody User user){
       userService.addUserI(user);
        return "Successfully added";
    }

    @GetMapping("/get")
   public List<User> getUsers(){
       List<User> userList= userService.getUsers();
       return userList;
    }


}
