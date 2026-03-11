package com.example.moodmusic.model;

public class Song {

    private String title;
    private String artist;
    private String url;
    private String image;
    private String mood;

    // Empty constructor
    public Song() {
    }

    // Constructor with 5 parameters
    public Song(String title, String artist, String url, String image, String mood) {
        this.title = title;
        this.artist = artist;
        this.url = url;
        this.image = image;
        this.mood = mood;
    }

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}