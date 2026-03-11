package com.example.moodmusic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.moodmusic.model.Song;

@RestController
@RequestMapping("/api/music")
@CrossOrigin
public class MusicController {

	@GetMapping("/{mood}")
	public List<Song> getSongs(@PathVariable String mood){

	List<Song> songs = new ArrayList<>();

	// HAPPY
	if(mood.equalsIgnoreCase("happy")){

	songs.add(new Song(
	"Believer",
	"Imagine Dragons",
	"https://www.youtube.com/embed/7wtfhZwyrcc",
	"https://img.youtube.com/vi/7wtfhZwyrcc/0.jpg",
	"happy"
	));
	songs.add(new Song(
			"Can't Stop the Feeling",
			"Justin Timberlake",
			"https://www.youtube.com/embed/ru0K8uYEZWw",
			"https://img.youtube.com/vi/ru0K8uYEZWw/0.jpg",
			"happy"
			));
	songs.add(new Song(
			"Kar Gayi Chull",
			"Badshah",
			"https://www.youtube.com/embed/NTHz9ephYTw",
			"https://img.youtube.com/vi/NTHz9ephYTw/0.jpg",
			"happy"
			));
	}

	// ROMANTIC
	if(mood.equalsIgnoreCase("romantic")){

	songs.add(new Song(
	"Kesariya",
	"Arijit Singh",
	"https://www.youtube.com/embed/BddP6PYo2gs",
	"https://img.youtube.com/vi/BddP6PYo2gs/0.jpg",
	"romantic"
	));

	songs.add(new Song(
	"Raabta",
	"Arijit Singh",
	"https://www.youtube.com/embed/zlt38OOqwDc",
	"https://img.youtube.com/vi/zlt38OOqwDc/0.jpg",
	"romantic"
	));
	songs.add(new Song(
			"Perfect",
			"Ed Sheeran",
			"https://www.youtube.com/embed/2Vv-BfVoq4g",
			"https://img.youtube.com/vi/2Vv-BfVoq4g/0.jpg",
			"romantic"
			));

	}

	// SAD
	if(mood.equalsIgnoreCase("sad")){

	songs.add(new Song(
	"Someone Like You",
	"Adele",
	"https://www.youtube.com/embed/hLQl3WQQoQ0",
	"https://img.youtube.com/vi/hLQl3WQQoQ0/0.jpg",
	"sad"
	));
	
	songs.add(new Song(
			"Channa Mereya",
			"Arijit Singh",
			"https://www.youtube.com/embed/284Ov7ysmfA",
			"https://img.youtube.com/vi/284Ov7ysmfA/0.jpg",
			"sad"
			));
	songs.add(new Song(
			"Kadhi Tu",
			"Hrishikesh Ranade",
			"https://www.youtube.com/embed/Q6w4YH0mKXQ",
			"https://img.youtube.com/vi/Q6w4YH0mKXQ/0.jpg",
			"sad"
			));

	}

	// RELAX
	if(mood.equalsIgnoreCase("relax")){

	songs.add(new Song(
	"Rain Sound",
	"Nature Sounds",
	"https://www.youtube.com/embed/mPZkdNFkNps",
	"https://img.youtube.com/vi/mPZkdNFkNps/0.jpg",
	"relax"
	));
	songs.add(new Song(
			"Perfect",
			"Ed Sheeran",
			"https://www.youtube.com/embed/2Vv-BfVoq4g",
			"https://img.youtube.com/vi/2Vv-BfVoq4g/0.jpg",
			"relax"
			));
	songs.add(new Song(
			"Raataan Lambiyan",
			"Jubin Nautiyal",
			"https://www.youtube.com/embed/gvyUuxdRdR4",
			"https://img.youtube.com/vi/gvyUuxdR4/0.jpg",
			"relax"
			));

	}

	return songs;

	}


    // TEXT MOOD DETECTION API
    @PostMapping("/detect")
    public String detectMood(@RequestBody String text){

        text = text.toLowerCase();

        if(text.contains("happy"))
            return "happy";

        if(text.contains("sad"))
            return "sad";

        if(text.contains("love"))
            return "romantic";

        return "relax";
    }

}