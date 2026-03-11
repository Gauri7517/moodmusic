package com.example.moodmusic.service;

import java.util.*;

import org.springframework.stereotype.Service;
import com.example.moodmusic.model.User;

@Service
public class UserService {

    Map<String,User> users=new HashMap<>();

    public String register(User user){

        if(users.containsKey(user.getUsername()))
            return "User already exists";

        users.put(user.getUsername(),user);

        return "Registered";
    }

    public User login(String username,String password){

        User user=users.get(username);

        if(user!=null && user.getPassword().equals(password))
            return user;

        return null;
    }
}