package com.jonah.vttp5_paf_day06l.models;

public class Song {
    private String songName;
    private String artist;
    private int released_year;


    

    public Song() {
    }


    
    public Song(String songName, String artist, int released_year) {
        this.songName = songName;
        this.artist = artist;
        this.released_year = released_year;
    }



    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public int getReleased_year() {
        return released_year;
    }
    public void setReleased_year(int released_year) {
        this.released_year = released_year;
    }
    
}
