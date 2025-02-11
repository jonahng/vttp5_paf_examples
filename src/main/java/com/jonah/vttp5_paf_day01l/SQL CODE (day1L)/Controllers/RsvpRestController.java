package com.jonah.vttp5_paf_day01l.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_paf_day01l.Models.Rsvp;
import com.jonah.vttp5_paf_day01l.Services.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class RsvpRestController {
    
    @Autowired
    GameService gameService;

    @GetMapping("/rsvps")
    public ResponseEntity<List<Rsvp>> getAllRsvps(){
        List<Rsvp> allRsvps = gameService.getRsvps();
        return ResponseEntity.ok().body(allRsvps);
    }


    @GetMapping("/rsvp/{name}")
    public ResponseEntity<List<Rsvp>> getRsvpFromName(@PathVariable("name") String name){
        List<Rsvp> possibleRsvp = gameService.getRsvpFromName(name);
        if(possibleRsvp.size() < 1){
            return ResponseEntity.ofNullable(null);
        }
        return ResponseEntity.ok().body(possibleRsvp);
    }


    @PostMapping("/rsvp")
    public ResponseEntity<String> postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        System.out.println("THE JSON RECEIVED IS" + entity);
        gameService.addRsvpToDatabase(gameService.RsvpFromJson(entity));
        return ResponseEntity.ok().body("OK YOU SENT IN " + entity);
    }


    @PutMapping("/rsvp")
    public ResponseEntity<String> putUpdate(@RequestBody String entity) {
        //TODO: process POST request
        System.out.println("THE JSON RECEIVED IS" + entity);
        Rsvp r = gameService.RsvpFromJson(entity);
        gameService.deleteRsvp(r.getEmail());
        gameService.addRsvpToDatabase(r);
        return ResponseEntity.ok().body("OK YOU SENT IN UPDATE" + entity);


    }
    @GetMapping("/rsvps/count")
    public ResponseEntity<String> rsvpCount(){
        return ResponseEntity.ok().body(gameService.getRsvpCOunt());
    }
    
}
