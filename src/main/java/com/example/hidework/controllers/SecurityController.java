package com.example.hidework.controllers;

import com.example.hidework.HideworkApplication;
import com.example.hidework.dto.SigninRequest;
import com.example.hidework.dto.SignupRequest;
import com.example.hidework.security.JwtCore;
import com.example.hidework.service.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.awt.print.PrinterJob;
import java.util.Objects;

@RequestMapping("/auth")
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:8080")
public class SecurityController {
    private final UserDetailsServiceImpl userService;

    @Autowired
    public SecurityController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    private JwtCore jwtCore;

    @PostMapping("/signup")
    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        String serviceResult = userService.newUser(signupRequest);
        if (signupRequest.getUserName() == null || signupRequest.getUserName().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Введите имя");
        }
        if (signupRequest.getPassword() == null || signupRequest.getPassword().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Введите пароль");
        }
        if (Objects.equals(serviceResult, "Выберите другое имя")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        if (Objects.equals(serviceResult, "Выберите другую почту")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        return ResponseEntity.ok("Вы успешно зарегистрированы. Теперь можете войти в свой аккаунт.");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {
        UserDetails user = userService.loadUserByUsername(signinRequest.getUserName());
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword=passwordEncoder.encode(signinRequest.getPassword());

        if (user == null || !user.getPassword().equals(signinRequest.getPassword())) {
            log.info("Ошибка авторизации пользователя " + signinRequest.getUserName());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Введите имя");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Введите пароль");
        }

        String jwt = jwtCore.generateToken(user);
        HideworkApplication.currentUser = userService.loadUserEntityByUsername(signinRequest.getUserName());
        log.info("Вход прошёл успешно");

        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/logout")
//    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            String userName = authentication.getName();
//            String jwt = jwtCore.generateNewToken(userName);
//
//            // Добавляем текущий токен в blacklist
//            jwtCore.addToBlacklist(request.getHeader("Authorization").replace("Bearer ", ""));
//
//            // Устанавливаем заголовок авторизации с новым токеном
//            response.setHeader("Authorization", "Bearer " + jwt);
//
//            return ResponseEntity.ok("Выход прошёл успешно. Токен был обновлен");
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Вы не авторизованы");
//        }
//    }
    ResponseEntity<?> logout(){
        HideworkApplication.currentUser=null;
        return ResponseEntity.ok("");
    }

}
