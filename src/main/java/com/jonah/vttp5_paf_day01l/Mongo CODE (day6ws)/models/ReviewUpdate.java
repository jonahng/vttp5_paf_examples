package com.jonah.vttp5_paf_day06ws.models;

public class ReviewUpdate {
    private String comment;
    private int rating;
    private long timestamp;


    
    public ReviewUpdate() {
    }



    
    public ReviewUpdate(String comment, int rating, long timestamp) {
        this.comment = comment;
        this.rating = rating;
        this.timestamp = timestamp;
    }




    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    

    
}
