package com.example.moodmusic.model;

import java.util.List;

public class User {

    private String username;
    private String password;
    private List<String> favorites;

    public User(){}

    public User(String username,String password){
        this.username=username;
        this.password=password;
    }

    public String getUsername(){ return username; }
    public String getPassword(){ return password; }

    public List<String> getFavorites(){ return favorites; }
    public void setFavorites(List<String> favorites){
        this.favorites=favorites;
    }
}