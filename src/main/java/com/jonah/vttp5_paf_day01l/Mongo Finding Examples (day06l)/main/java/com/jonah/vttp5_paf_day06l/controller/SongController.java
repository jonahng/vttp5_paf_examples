package com.jonah.vttp5_paf_day06l.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonah.vttp5_paf_day06l.models.Song;
import com.jonah.vttp5_paf_day06l.services.SongService;

@Controller
@RequestMapping("")
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/topsongs/")
    public String getTopSongsInYear(@RequestParam("Year") int year, Model model){
        List<Document> topSongs = songService.getTopSongsInYear(year);
        System.out.println(topSongs);
        List<Song> songList = new ArrayList<>();

        for(Document songJson: topSongs){
            Song song = new Song();
            


            try {
                song.setSongName(songJson.get("track_name").toString());
                song.setArtist(songJson.getString("artist(s)_name"));
            song.setReleased_year(songJson.getInteger("released_year"));
            System.out.println(songJson.getString("track_name"));
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR WITH THIS SONG NAME\n" + songJson.get("track_name").toString());
            }
            


            songList.add(song);
        }

        model.addAttribute("songList",songList);
        model.addAttribute("year", year);
        return "songList";
    }


    @GetMapping("")
    public String chooseYear(Model model){
        List<Integer> topYears = songService.getTopYears();

        model.addAttribute("years", topYears);

        return "chooseYear";
    }
    
}
