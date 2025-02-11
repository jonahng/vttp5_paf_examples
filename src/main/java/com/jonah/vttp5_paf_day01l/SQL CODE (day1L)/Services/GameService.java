package com.jonah.vttp5_paf_day01l.Services;

import java.io.StringReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day01l.Models.Book;
import com.jonah.vttp5_paf_day01l.Models.Game;
import com.jonah.vttp5_paf_day01l.Models.Rsvp;
import com.jonah.vttp5_paf_day01l.repositories.GameRepository;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepo;


    public List<Game> getGames(){
        return gameRepo.selectGames();
    }

    public List<Game> getGamesLimit(int limit){
        return gameRepo.getGamesLimit(limit);
    }

    public List<Book> getBooks(){
        return gameRepo.getBooks();
    }

    public List<Book> getBookSearch(String author, int limit){
        return gameRepo.getBookSearch(author, limit);
    }

    public Book getBookFromAsin(String asin){
        return gameRepo.getBookFromAsin(asin);
    }

    public void printAuthors(float rating){
        gameRepo.getAuthorRanking(rating);
    }

    public List<Rsvp> getRsvps(){
        return gameRepo.getAllRsvps();
    }

    public List<Rsvp> getRsvpFromName(String name){
        return gameRepo.getRsvpFromName(name);
    }

    public Rsvp RsvpFromJson(String stringJson){
        JsonReader jsonReader = Json.createReader(new StringReader(stringJson));
        JsonObject rjson = jsonReader.readObject();
        Rsvp r = new Rsvp();

        try {
        r.setEmail(rjson.getString("email"));
        r.setName(rjson.getString("name"));
        r.setPhone(rjson.getString("phone"));
        r.setDate(rjson.getString("confirmDate"));
        r.setComments(rjson.getString("comments"));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("MISSING FIELDS!");
        }
        return r;
    }

    public void addRsvpToDatabase(Rsvp r){
        gameRepo.addRsvpToDatabase(r);
    }

    public String getRsvpCOunt(){
        return gameRepo.getRsvpCount();
    }

    public void deleteRsvp(String email){
      gameRepo.deleteRsvp(email);
    }
}
