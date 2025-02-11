package com.jonah.vttp5_paf_day06ws.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_paf_day06ws.models.GameDetail;
import com.jonah.vttp5_paf_day06ws.models.GameList;
import com.jonah.vttp5_paf_day06ws.services.GameService;

import jakarta.json.JsonObject;

@RestController
@RequestMapping("")
public class GameRestController {
    @Autowired
    GameService gameService;


    @GetMapping("/games")
    public ResponseEntity<GameList> getSomeGames(@RequestParam(defaultValue = "25") int limit,@RequestParam(defaultValue = "0") int offset){
       GameList response =  gameService.getSomeGames(limit, offset);
       System.out.println("IN RESTCONTROLLER, RESPONSE IS\n" + response);
       return ResponseEntity.ok().body(response);

        
    }

    @GetMapping("/games/rank")
    public ResponseEntity<GameList> getGamesRanked(@RequestParam(defaultValue = "25") int limit,@RequestParam(defaultValue = "0") int offset){
        return ResponseEntity.ok().body(gameService.getRankedGames(limit, offset));
    }

    @GetMapping("/game/{game-id}")
    public ResponseEntity<Object> getGameFromId(@PathVariable("game-id") String gameId){

        GameDetail gameDetails = gameService.getGameFromId(gameId);
        if(gameDetails.getGame_id() < 1){
            return ResponseEntity.ok().body("sorry no content found");
        }

        return ResponseEntity.ok().body(gameDetails);

    }
    
}


/* @GetMapping("/health")
    public ResponseEntity<String> checkProgram(){
        //if STATEMENT can connect to redis or open file or some critical function
        if(true){
            return ResponseEntity.ok("{}"); //successful
        }
        return ResponseEntity.status(400).body("{}"); //error

    } */