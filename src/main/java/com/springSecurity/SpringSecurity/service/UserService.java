package com.springSecurity.SpringSecurity.service;

import com.springSecurity.SpringSecurity.model.User;

import java.util.List;

public interface UserService {
    User addUserI(User user);
    List<User> getUsers();
}
