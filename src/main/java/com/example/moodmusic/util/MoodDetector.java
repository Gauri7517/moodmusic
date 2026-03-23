package com.example.moodmusic.util;

public class MoodDetector {

    public static String detectMood(String text){

        text=text.toLowerCase();

        if(text.contains("relax") || text.contains("tired") || text.contains("stress"))
            return "relax";

        if(text.contains("happy") || text.contains("excited"))
            return "happy";

        if(text.contains("sad") || text.contains("cry"))
            return "sad";

        if(text.contains("love") || text.contains("romantic"))
            return "romantic";

        return "happy";
    }
}