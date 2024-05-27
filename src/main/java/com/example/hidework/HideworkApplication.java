package com.example.hidework;


import com.example.hidework.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class HideworkApplication  {

    public static ApplicationContext context;
    public static User currentUser;
    public static void main(String[] args) {
        SpringApplication.run(HideworkApplication.class, args);

    }

}
