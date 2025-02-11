package com.jonah.vttp5_paf_day06ws.models;

import java.time.LocalDateTime;
import java.util.Date;

public class GameDetail {
    private int game_id;
    private String name;
    private int year;
    private int ranking;
    private int users_rated;
    private String url;
    private String thumbnail;
    private LocalDateTime timestamp;




    
    public GameDetail() {
    }


    
    public GameDetail(int game_id, String name, int year, int ranking, int users_rated, String url, String thumbnail,
            LocalDateTime timestamp) {
        this.game_id = game_id;
        this.name = name;
        this.year = year;
        this.ranking = ranking;
        this.users_rated = users_rated;
        this.url = url;
        this.thumbnail = thumbnail;
        this.timestamp = timestamp;
    }



    public int getGame_id() {
        return game_id;
    }
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public int getUsers_rated() {
        return users_rated;
    }
    public void setUsers_rated(int users_rated) {
        this.users_rated = users_rated;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


    
    
}
