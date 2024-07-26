package com.example.hidework.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.FetchType.EAGER;


@Entity
@Data
@Table(name = "User", schema = "schema", catalog = "postgres")
public class User{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;
    @Column(name = "userName")
    private  String userName;
    @Column(name = "userAge")
    private int userAge;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @ManyToMany(fetch = EAGER)
    private List<Role> roles;

}