package com.springSecurity.SpringSecurity.service.impl;

import com.springSecurity.SpringSecurity.entity.User;
import com.springSecurity.SpringSecurity.repository.UserRepository;
import com.springSecurity.SpringSecurity.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public User addUserI(User user) {
       userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> userList=userRepository.findAll();
        return userList;
    }
}
