package com.jonah.vttp5_paf_day01l.Models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Rsvp {
    private String email;
    private String phone;
    private String date;
    private String comments;
    private String name;



    
    
    public Rsvp() {
    }

    

    public Rsvp(String email, String phone, String date, String comments, String name) {
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.comments = comments;
        this.name = name;
    }

    public static Rsvp toRsvp(SqlRowSet rs){
        Rsvp r = new Rsvp();
            r.setComments(rs.getString("comments"));
            r.setDate(rs.getDate("confirmDate").toString());
            r.setEmail(rs.getString("email"));
            r.setName(rs.getString("name"));
            r.setPhone(rs.getString("phone"));
        return r;

    }



    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
