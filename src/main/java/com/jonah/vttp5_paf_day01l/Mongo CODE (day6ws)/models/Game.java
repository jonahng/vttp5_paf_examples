package com.jonah.vttp5_paf_day06ws.models;

public class Game {
    private int gid;
    private String name;


    
    public Game() {
    }
    
    public Game(int gid, String name) {
        this.gid = gid;
        this.name = name;
    }

    public int getGid() {
        return gid;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    
}
