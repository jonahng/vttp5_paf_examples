package com.jonah.vttp5_paf_day03ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_paf_day03ws.models.OrderInfo;
import com.jonah.vttp5_paf_day03ws.services.NorthService;

@RestController
@RequestMapping("")
public class NorthController {
    @Autowired
    NorthService northService;

    @GetMapping("/orders/{order_id}")
    public ResponseEntity<List<OrderInfo>> getAllOrderInfo(@PathVariable("order_id") String order_id){
        
        return ResponseEntity.ok().body(northService.getAllOrderInfo(Integer.parseInt(order_id)));
    }
    
}
