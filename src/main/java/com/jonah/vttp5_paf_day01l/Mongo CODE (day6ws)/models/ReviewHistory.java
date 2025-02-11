package com.jonah.vttp5_paf_day06ws.models;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewHistory {
    private String userName;
    private int rating;
    private String comment;
    private int gameId;
    private LocalDateTime postedDateTime;
    private String gameName;
    private List<ReviewUpdate> edited;
    private long timestamp;

    

    public ReviewHistory() {
    }

    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getGameId() {
        return gameId;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    public LocalDateTime getPostedDateTime() {
        return postedDateTime;
    }
    public void setPostedDateTime(LocalDateTime postedDateTime) {
        this.postedDateTime = postedDateTime;
    }
    public String getGameName() {
        return gameName;
    }
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    public List<ReviewUpdate> getEdited() {
        return edited;
    }
    public void setEdited(List<ReviewUpdate> edited) {
        this.edited = edited;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    


    
}
