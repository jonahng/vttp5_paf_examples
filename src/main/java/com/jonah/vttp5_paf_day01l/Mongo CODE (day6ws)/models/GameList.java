package com.jonah.vttp5_paf_day06ws.models;

import java.util.Date;
import java.util.List;

public class GameList {
    private List<Game> games;
    private int offset;
    private int limit;
    private int total;
    private Date timestamp;



    
    public GameList() {
    }

    
    public GameList(List<Game> games, int offset, int limit, int total, Date timestamp) {
        this.games = games;
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.timestamp = timestamp;
    }


    public List<Game> getGames() {
        return games;
    }
    public void setGames(List<Game> games) {
        this.games = games;
    }
    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    
    
}
