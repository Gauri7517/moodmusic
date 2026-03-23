package com.example.moodmusic.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.moodmusic.model.Song;

@Service
public class MusicService {

    public List<Song> getSongsByMood(String mood){

        List<Song> songs=new ArrayList<>();

        if(mood.equals("happy")){

            songs.add(new Song("Happy Song","Artist1",
            "songs/happy1.mp3","img/happy.jpg","happy"));

        }

        if(mood.equals("sad")){

            songs.add(new Song("Sad Song","Artist2",
            "songs/sad1.mp3","img/sad.jpg","sad"));

        }

        return songs;

    }

}