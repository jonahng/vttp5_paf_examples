package com.jonah.vttp5_paf_day03ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day03ws.models.OrderInfo;
import com.jonah.vttp5_paf_day03ws.repo.NorthRepo;

@Service
public class NorthService {
    @Autowired
    NorthRepo northRepo;

    public List<OrderInfo> getAllOrderInfo(int orderId){
        List<OrderInfo> allOrderInfo =northRepo.orderInfo(orderId);
        return allOrderInfo;
    }
    
}
