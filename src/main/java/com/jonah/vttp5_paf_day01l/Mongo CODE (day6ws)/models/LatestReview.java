package com.jonah.vttp5_paf_day06ws.models;

import java.time.LocalDateTime;

public class LatestReview {
    private String userName;
    private int rating;
    private String comment;
    private int gameId;
    private LocalDateTime postedDateTime;
    private String gameName;
    private boolean edited;
    private long timestamp;



    
    public LatestReview() {
    }

    
    public LatestReview(String userName, int rating, String comment, int gameId, LocalDateTime postedDateTime,
            String gameName, boolean edited, long timestamp) {
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
        this.gameId = gameId;
        this.postedDateTime = postedDateTime;
        this.gameName = gameName;
        this.edited = edited;
        this.timestamp = timestamp;
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
    public boolean isEdited() {
        return edited;
    }
    public void setEdited(boolean edited) {
        this.edited = edited;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    
}
