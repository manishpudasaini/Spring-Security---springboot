package com.springSecurity.SpringSecurity.controller;

import com.springSecurity.SpringSecurity.model.User;
import com.springSecurity.SpringSecurity.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        User user1=userService.addUserI(user);
        return user1;
    }

    @GetMapping("/get")
   public List<User> getUsers(){
       List<User> userList= userService.getUsers();
       return userList;
    }
}
