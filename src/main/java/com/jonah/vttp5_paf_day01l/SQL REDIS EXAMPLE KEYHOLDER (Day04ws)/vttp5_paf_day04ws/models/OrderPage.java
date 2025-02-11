package com.jonah.vttp5_paf_day04ws.models;

import java.time.LocalDate;

public class OrderPage {

    private int order_id;

    private LocalDate order_date;

    private String customer_name;

    private String ship_address;

    private String notes;

    private double tax;




    private int details_id;

    private String product;

    private double unit_price;

    private double discount;

    private int quantity;


    


    



    @Override
    public String toString() {
        return "OrderPage [order_id=" + order_id + ", order_date=" + order_date + ", customer_name=" + customer_name
                + ", ship_address=" + ship_address + ", notes=" + notes + ", tax=" + tax + ", details_id=" + details_id
                + ", product=" + product + ", unit_price=" + unit_price + ", discount=" + discount + ", quantity="
                + quantity + "]";
    }


    public OrderPage() {
    }
    

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getShip_address() {
        return ship_address;
    }

    public void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getDetails_id() {
        return details_id;
    }

    public void setDetails_id(int details_id) {
        this.details_id = details_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




    
    
}
