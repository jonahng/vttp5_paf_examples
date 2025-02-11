package com.jonah.vttp5_paf_day01l.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.jonah.vttp5_paf_day01l.Models.Book;
import com.jonah.vttp5_paf_day01l.Models.Game;
import com.jonah.vttp5_paf_day01l.Models.Rsvp;

import static com.jonah.vttp5_paf_day01l.repositories.Queries.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Game> selectGames(){
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAME);
        //rowset is saved in memory, so it will overwhelm the com, must limit number of results
        //the pointer is pointed at nothing. must call .next one time to move it to the first result
        List<Game> results = new ArrayList<>();
        while (rs.next()) {
            results.add(Game.toGame(rs));
        }
        return results;
    }

    public List<Game> getGamesLimit(int limit){
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAME_LIMIT, limit);
        List<Game> results = new ArrayList<>();
        while (rs.next()) {
            results.add(Game.toGame(rs));
        }
        return results;
    }

    public List<Game> getGamesAuthor(int limit, String author){
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAME_LIMIT, limit);
        List<Game> results = new ArrayList<>();
        while (rs.next()) {
            results.add(Game.toGame(rs));
        }
        return results;
    }


    public List<Book> getBooks(){
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_BOOK_LIMIT);
        List<Book> bookResults = new ArrayList<>();
        while (rs.next()) {
            bookResults.add(Book.toBook(rs));
            
        }
        return bookResults;
    }

    public List<Book> getBookSearch(String author, int limit){
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_BOOK_AUTHOR_LIMIT,'%'+author+'%', limit);
        System.out.println("Trying to find books.");
        System.out.println("result for sql is" + rs);
        List<Book> results = new ArrayList<>();
        while (rs.next()) {
            results.add(Book.toBook(rs));
            System.out.println(rs);
        }
        return results;

    }

    public Book getBookFromAsin(String asin){
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_BOOK_ASIN, asin);
        System.out.println("FINDING INDIVIDUAL BOOK FROM ASIN" + asin);
        Book book = new Book();
        while (rs.next()) {
            book = Book.toBook(rs);
        }
        return book;
    }

/*     //public Optional<Book> getBookOptional(String asin){
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_BOOK_ASIN,asin);
        
        //opt.isEmpty, opt.get() in the controller, to check whether the optional is empty or contains the book.
    } */


    public void getAuthorRanking(float avg_stars){
        SqlRowSet rs = template.queryForRowSet(SQL_AUTHOR_RANKINGS, avg_stars);

        if(!rs.next()){
            System.out.println("no authors");
            return;
        }

        while (rs.next()) {
            String author = rs.getString("author");
            String average_stars = rs.getString("avg_stars");
            String count = rs.getString("count");

        System.out.println(author + average_stars + count);
        }
        
    }

    public List<Rsvp> getAllRsvps(){

        SqlRowSet rs = template.queryForRowSet(SQL_ALL_RSVPS);

        List<Rsvp> allRsvps = new ArrayList<>();
        while(rs.next()){
            Rsvp r = Rsvp.toRsvp(rs);
            System.out.println(r.getEmail() + r.getPhone());
            allRsvps.add(r);
        }

        return allRsvps;
    }


    public List<Rsvp> getRsvpFromName(String name){
        SqlRowSet rs = template.queryForRowSet(SQL_FIND_RSVP_FROM_NAME, '%' + name + '%');
        List<Rsvp> allRsvps = new ArrayList<>();
        while(rs.next()){
            Rsvp r = Rsvp.toRsvp(rs);
            System.out.println(r.getEmail() + r.getPhone());
            allRsvps.add(r);
        }

        return allRsvps;

    }

    public void addRsvpToDatabase(Rsvp r){
        int added = template.update(SQL_ADD_RSVP_TO_DATABASE,r.getEmail(),r.getPhone(),r.getDate(),r.getComments(),r.getName());
        System.out.println("added : " + added);
    }


    public void updateRsvpInDatabase(Rsvp r){

    }

    public String getRsvpCount(){
        SqlRowSet rs = template.queryForRowSet(SQL_COUNT_RSPVS);
        String count = "";
        while (rs.next()) {
            count = rs.getString("rsvpCount");
            
        }
        return count;
    }

    public void deleteRsvp(String email){
        template.update(SQL_DELETE_RSVP, email);
    }
    

}
