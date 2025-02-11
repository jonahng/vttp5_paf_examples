package com.jonah.vttp5_paf_day03ws.repo;

public class Queries {
    public static final String SQL_GET_ALL_ORDER_INFO = """
            select *, 
quantity*unit_price as total_order_price,
quantity*standard_cost as cost_price
from orders as o
left join order_details as od
on o.id=od.order_id 
left join products as p
on od.product_id=p.id 
where o.id = ?
;
            """;

    
}
