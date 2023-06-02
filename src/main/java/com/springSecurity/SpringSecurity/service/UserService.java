package com.springSecurity.SpringSecurity.service;

import com.springSecurity.SpringSecurity.entity.UserInfo;


import java.util.List;

public interface UserService {
    UserInfo addUserI(UserInfo user);
    List<UserInfo> getUsers();
}
