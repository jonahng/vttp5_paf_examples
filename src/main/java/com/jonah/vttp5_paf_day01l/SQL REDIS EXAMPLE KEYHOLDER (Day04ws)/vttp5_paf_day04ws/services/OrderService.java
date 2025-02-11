package com.jonah.vttp5_paf_day04ws.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonah.vttp5_paf_day04ws.models.OrderPage;
import com.jonah.vttp5_paf_day04ws.repos.ListRepo;
import com.jonah.vttp5_paf_day04ws.repos.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

        @Autowired
    private ListRepo listRepo;



    public void writeToOrder(OrderPage op){
        orderRepo.addOrder(op);
    }

    public void writeToDetail(OrderPage op) throws Exception{
        orderRepo.addDetail(op);
    }

    public void writeToRedis(OrderPage op){
        System.out.println("TRYING TO ADD TO LISTREPO");
        listRepo.leftPush("messages", op.toString());

    }


    @Transactional
    public void writeOrderPage(OrderPage op){

        try {
            op.setOrder_date(LocalDate.now());
            int orderId = orderRepo.addOrderWithKeyholder(op);
            //orderRepo.addOrder(op);
            op.setOrder_id(orderId);
            orderRepo.addDetail(op);
        } catch (Exception e) {
            System.out.println("EXCEPTION CAUSED:");
            System.err.print(e.toString());
            // TODO: handle exception
        }

       
    }

    
}
