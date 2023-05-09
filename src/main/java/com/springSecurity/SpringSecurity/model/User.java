package com.springSecurity.SpringSecurity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @Column(name = "name",length = 25)
    private String name;
    @Column(name = "address",length = 35)
    private String address;
    @Column(name = "phone",length = 10)
    private String phone;
    @Column(name = "email",length = 60)
    private String email;
}
