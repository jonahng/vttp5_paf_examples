package com.jonah.vttp5_paf_day06ws.repos;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.jonah.vttp5_paf_day06ws.models.ReviewUpdate;

@Repository
public class GameRepo {
    @Autowired
    private MongoTemplate template;

    public void getAllGames(){
        Criteria criteria = Criteria.where("");
        Query query = Query.query(criteria);
        List<Document> results = template.find(query, Document.class, "games");
        System.out.println("READING THE FILE:" + results);
    }

    public List<Document> getSomeGames(int limit, int offset){
        Criteria criteria = Criteria.where("");
        Query query = Query.query(criteria).limit(limit).skip(offset);
        List<Document> results = template.find(query, Document.class, "games");
        System.out.println("SOME GAMES: " + results);
        return results;
    }

    public List<Document> getGamesRanked(int limit, int offset){
        Criteria criteria = Criteria.where("");
        Query query = Query.query(criteria).with(Sort.by(Direction.ASC, "ranking")).limit(limit).skip(offset);
        //query.fields().include("ranking", "id"); TO GET ONLY SOME FIELDS
        List<Document> results = template.find(query, Document.class, "games");
        System.out.println("ranked results are: \n" + results);
        return results;

    }

    public List<Document> getGameFromId(String gameId){   
        Criteria criteria = Criteria.where("gid").is(Integer.parseInt(gameId));
        Query query = Query.query(criteria);
        List<Document> result = template.find(query, Document.class, "games");
        System.out.println("THE GAME IS: " + result);
        return result;

    }


    



    
}
