package com.jonah.vttp5_paf_day04ws.repos;

public class Queries {

    public static final String SQL_TEMPLATE = """ 
    
    """;


    public static final String SQL_ORDER_INSERT = """ 
    insert into orders(order_date,customer_name,ship_address,notes,tax)
    values(?, ?, ?, ?, ?);
    """;
    


    public static final String SQL_DETAIL_INSERT = """ 
    INSERT into order_details(product,unit_price,discount,quantity, order_id)
    values(?,?,?,?,?);
    """;
    
    
}
