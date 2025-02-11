package com.jonah.vttp5_paf_day06ws.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day06ws.models.Game;
import com.jonah.vttp5_paf_day06ws.models.GameDetail;
import com.jonah.vttp5_paf_day06ws.models.GameList;
import com.jonah.vttp5_paf_day06ws.repos.GameRepo;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

@Service
public class GameService {
    @Autowired
    GameRepo gameRepo;


    public GameList getSomeGames(int limit, int offset){
        List<Document> results = gameRepo.getSomeGames(limit, offset);
        List<Game> gameList = new ArrayList<>();
       /*  List<JsonObject> jsonGameList = new ArrayList<>(); */
        
        for(Document d : results){
            Game g = new Game();
            g.setGid(d.getInteger("gid"));
            g.setName(d.getString("name"));
            gameList.add(g);

           /*  JsonObjectBuilder jObjectBuilder = Json.createObjectBuilder();
            jObjectBuilder.add("game_id", d.getInteger("gid"));
            jObjectBuilder.add("name", d.getString("name"));
            JsonObject jsonObject = jObjectBuilder.build();
            jsonGameList.add(jsonObject); */
        }

        

       /*  JsonArrayBuilder jArrayBuilder = Json.createArrayBuilder();
        for(JsonObject j: jsonGameList){
            jArrayBuilder.add(j);
        }
        JsonArray jArray = jArrayBuilder.build();
        System.out.println("PRINTING OUT JSON ARRAY OF GAMES: \n" + jArray);

        JsonObjectBuilder finalObjectBuilder = Json.createObjectBuilder();
        finalObjectBuilder.add("games", jArray);
        finalObjectBuilder.add("offset", offset);
        finalObjectBuilder.add("limit", limit);
        finalObjectBuilder.add("total", results.size());
        //finalObjectBuilder.add("timestamp", )
        JsonObject httpReply = finalObjectBuilder.build();
        System.out.println("final Json is:\n" + httpReply); */



        GameList gameListModel = new GameList();
        gameListModel.setGames(gameList);
        gameListModel.setLimit(limit);
        gameListModel.setOffset(offset);
        gameListModel.setTotal(results.size());
        //gameListModel.setTimestamp(results.);

        return gameListModel;

    }

    public GameList getRankedGames(int limit, int offset){
        List<Document> results = gameRepo.getGamesRanked(limit, offset);
        List<Game> gameList = new ArrayList<>();

        for(Document d : results){
            Game g = new Game();
            g.setGid(d.getInteger("gid"));
            g.setName(d.getString("name"));
            gameList.add(g);
        }
        GameList gameListModel = new GameList();
        gameListModel.setGames(gameList);
        gameListModel.setLimit(limit);
        gameListModel.setOffset(offset);
        gameListModel.setTotal(results.size());

        return gameListModel;

    }

    public GameDetail getGameFromId(String gameId){
        List<Document> result = gameRepo.getGameFromId(gameId);
        GameDetail gd = new GameDetail();
 

        for(Document d: result){
            gd.setGame_id(d.getInteger("gid"));
            gd.setName(d.getString("name"));
            gd.setRanking(d.getInteger("ranking"));
            gd.setThumbnail(d.getString("image"));
            gd.setUrl(d.getString("url"));
            gd.setUsers_rated(d.getInteger("users_rated"));
            gd.setYear(d.getInteger("year"));
            gd.setTimestamp(LocalDateTime.now());
        }


        return gd;
    }

    
}
