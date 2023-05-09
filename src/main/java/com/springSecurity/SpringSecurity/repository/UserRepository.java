package com.springSecurity.SpringSecurity.repository;

import com.springSecurity.SpringSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Short> {
}
