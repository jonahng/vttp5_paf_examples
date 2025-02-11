package com.jonah.vttp5_paf_day03ws.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.jonah.vttp5_paf_day03ws.models.OrderInfo;

@Repository
public class NorthRepo {
    @Autowired
    private JdbcTemplate template;

    public List<OrderInfo> orderInfo(int order_id){
        List<OrderInfo> allOrderInfo = new ArrayList<>();

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_ALL_ORDER_INFO, order_id);
        while (rs.next()) {
            //System.out.println("THE DATA READ IS:" + "the product id is:"+ rs.getString("product_id") + "the total order price is" + rs.getDouble("total_order_price"));
            OrderInfo orderInfo = OrderInfo.rsToOrderInfo(rs);
            allOrderInfo.add(orderInfo);
            }

        return allOrderInfo;

    }


    
}
