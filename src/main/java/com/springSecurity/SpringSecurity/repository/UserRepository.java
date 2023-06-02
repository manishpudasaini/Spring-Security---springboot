package com.springSecurity.SpringSecurity.repository;

import com.springSecurity.SpringSecurity.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo,Long> {
    Optional<UserInfo> findByName(String username);
}
