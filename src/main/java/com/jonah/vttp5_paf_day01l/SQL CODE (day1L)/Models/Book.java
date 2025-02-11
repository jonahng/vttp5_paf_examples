package com.jonah.vttp5_paf_day01l.Models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Book {
    private String asin;
    private String title;
    private String author;
    private String imgUrl;
    private String productURL;
    private double stars;
    private int reviews;




    


    public Book() {
    }

    public Book(String asin, String title, String author, String imgUrl, String productURL, double stars, int reviews) {
        this.asin = asin;
        this.title = title;
        this.author = author;
        this.imgUrl = imgUrl;
        this.productURL = productURL;
        this.stars = stars;
        this.reviews = reviews;
    }


    public static Book toBook(SqlRowSet rs){
        Book b = new Book();
        b.setAsin(rs.getString("asin"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setImgUrl(rs.getString("imgUrl"));
        b.setProductURL(rs.getString("productURL"));
        b.setStars(rs.getFloat("stars"));
        b.setReviews(rs.getInt("reviews"));

        return b;
    }




    public String getAsin() {
        return asin;
    }
    public void setAsin(String asin) {
        this.asin = asin;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getProductURL() {
        return productURL;
    }
    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }
    public double getStars() {
        return stars;
    }
    public void setStars(double stars) {
        this.stars = stars;
    }
    public int getReviews() {
        return reviews;
    }
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
    
    
}
