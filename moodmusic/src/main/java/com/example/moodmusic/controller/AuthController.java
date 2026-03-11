package com.example.moodmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.moodmusic.model.User;
import com.example.moodmusic.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public String register(@RequestBody User user){

        return service.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){

        return service.login(user.getUsername(),user.getPassword());
    }
}