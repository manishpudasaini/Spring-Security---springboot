package com.springSecurity.SpringSecurity.service.impl;

import com.springSecurity.SpringSecurity.entity.UserInfo;
import com.springSecurity.SpringSecurity.repository.UserRepository;
import com.springSecurity.SpringSecurity.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserInfo addUserI(UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);
        return user;
    }

    @Override
    public List<UserInfo> getUsers() {
        List<UserInfo> userList=userRepository.findAll();
        return userList;
    }
}
