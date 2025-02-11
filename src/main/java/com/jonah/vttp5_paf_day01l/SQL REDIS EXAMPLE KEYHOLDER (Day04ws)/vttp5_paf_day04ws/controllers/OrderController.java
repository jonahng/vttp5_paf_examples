package com.jonah.vttp5_paf_day04ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonah.vttp5_paf_day04ws.models.OrderPage;
import com.jonah.vttp5_paf_day04ws.services.OrderService;

@Controller
@RequestMapping("")
public class OrderController {
    @Autowired
    OrderService orderService;


    @GetMapping("")
    public String orderForm(Model model){
        OrderPage orderPage = new OrderPage();

        model.addAttribute("op",orderPage);


        return "createOrderForm";
        
    }


    @PostMapping("/order")
    public String receiveOrderForm(@ModelAttribute("op") OrderPage orderPage){
        System.out.println("THE ORDER PAGE RECEIVED IS :" + orderPage.getCustomer_name() + orderPage.getNotes());
        orderService.writeToRedis(orderPage);


        //orderService.writeOrderPage(orderPage);

        return "redirect:";
    }
    
}
