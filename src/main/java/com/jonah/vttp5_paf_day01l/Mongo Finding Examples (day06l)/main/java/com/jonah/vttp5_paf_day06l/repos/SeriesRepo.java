package com.jonah.vttp5_paf_day06l.repos;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static com.jonah.vttp5_paf_day06l.repos.Constants.*;

import java.util.List;

@Repository
public class SeriesRepo {
    @Autowired
    private MongoTemplate template;

    /* 
      db.series.find({
        name:{
        $regex:'name',
        $options: "i"       options makes it case insensitive
        }
         }).projections
     */

    public List<Document> findSeriesByName(String name){
        //criterea
        Criteria criteria = Criteria.where(F_NAME) //F_NAME is the field name in the database
            .regex(name, "i");

        //create the query
        Query query = Query.query(criteria);//make sure to import the springboot query
        query.fields().include("name", "id", "summary","image.original","schedule","genres").exclude("_id"); //for projection, so database does not return unnecessary fields

        //perform the query
        List<Document> results = template.find(query, Document.class, "series"); //Series is the name of the collection inside the database, 
        // Import Document is org.bson
        return results;



    }

    /* 
     db.series.find({
    "rating.average":{$gte:8}
     })
    .sort({"rating.average":-1})
    .limit(10)
     */
    public List<Document> findSeriesByRating(float rating){
        Criteria criteria = Criteria.where(F_RATING_AVERAGE)
        .gte(rating);
        //which operations belong to criteria or query?
        //Sorting and limit are in qery
        Query query = Query.query(criteria)
        .with(Sort.by(Direction.DESC, F_RATING_AVERAGE)).limit(5);
        query.fields().include("name", "id", "summary","image.original","schedule","genres");

        return template.find(query, Document.class, C_SERIES); //c_series is "series"

    }

    /* 
     db.series.distinct('type')
     this gets all the types of shows, no repeats in the categories
     */
    //this finds all the different types of shows, and returns one of each type
     public List<String> findTypeOfSeries(){
        return template.findDistinct(new Query(), "type", C_SERIES, String.class);
     }

     //db.songs.find({ released_year: year}).projection({track_name:1, 'artost(s)_name':1}).sort({track_name:1})
     public List<Document> findTopSongsYear(int year){
        Criteria criteria = Criteria.where("released_year").is(year);
        Query query = Query.query(criteria);

        //query.fields().include("artist","id")
        return template.find(query, Document.class, "songs");

     }

     public List<Integer> findYearsTopSongs(){
        List<Integer> topYearList= template.findDistinct(new Query(), "released_year", "songs", Integer.class);
        return topYearList;
     }
}
