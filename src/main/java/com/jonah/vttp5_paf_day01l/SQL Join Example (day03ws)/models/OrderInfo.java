package com.jonah.vttp5_paf_day03ws.models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.sql.RowSet;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class OrderInfo {
    private int order_id;
    private LocalDateTime order_date;
    private int customer_id;
    private double total_order_price;
    private double cost_price;




    
    public OrderInfo() {
    }



    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public LocalDateTime getOrder_date() {
        return order_date;
    }
    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public double getTotal_order_price() {
        return total_order_price;
    }
    public void setTotal_order_price(double total_order_price) {
        this.total_order_price = total_order_price;
    }
    public double getCost_price() {
        return cost_price;
    }
    public void setCost_price(double cost_price) {
        this.cost_price = cost_price;
    }


    public static OrderInfo rsToOrderInfo(SqlRowSet rs){
        OrderInfo o = new OrderInfo();
        try {
        o.setCost_price(rs.getDouble("cost_price"));
        o.setOrder_id(rs.getInt("order_id"));
        o.setTotal_order_price(rs.getDouble("total_order_price"));
        o.setCustomer_id(rs.getInt("customer_id"));

        String date = rs.getString("order_date");
        System.out.println("THE DATE IS:" + date);
        LocalDateTime dateTime = LocalDateTime.parse(date);
        System.out.println("THE DATETIME PARSING IS:" + dateTime);
        o.setOrder_date(dateTime);
        

        //System.out.println("THE TOTAL ORDER PRICE IS:" + rs.getDouble("total_order_price"));
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR READING THE ROWSET DATA");
        }
        
        return o;
    }

    


    
}
