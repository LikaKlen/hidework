package com.example.hidework.models;

import jakarta.persistence.*;
import lombok.Data;


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
    public String password;
    @Column(name = "role")
    public String role;
//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "roleId")
//    private Role role;


}