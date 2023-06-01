package com.springSecurity.SpringSecurity.repository;

import com.springSecurity.SpringSecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
