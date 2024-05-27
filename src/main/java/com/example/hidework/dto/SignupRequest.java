package com.example.hidework.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String userName;
    private String password;
    private String email;
    private int userAge;
    private String role;
//    public SignupRequest(String userName, String password) {
//        this.userName = userName;
//        this.password = password;
//    }

}
