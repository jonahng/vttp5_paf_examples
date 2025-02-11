package com.jonah.vttp5_paf_day04ws.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jonah.vttp5_paf_day04ws.models.OrderPage;

@Repository
public class OrderRepo {
    @Autowired
    private JdbcTemplate template;



    public void addOrder(OrderPage op){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int added = template.update(Queries.SQL_ORDER_INSERT,op.getOrder_date(), op.getCustomer_name(), op.getShip_address(), op.getNotes(), op.getTax());
        System.out.println("WROTE :" + added);
        System.out.println("THE KEY WRITTEN IS:" + keyHolder.getKey());
    }

    //MYSQL MUST HAVE THE TABLES SET UP BEFOREHAND!
    public int addOrderWithKeyholder(OrderPage op) throws Exception{

        try {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {
          @Override
          public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
            
            PreparedStatement ps = con.prepareStatement(Queries.SQL_ORDER_INSERT, new String[] {"id"});
            ps.setString(1, op.getOrder_date().toString());
            ps.setString(2, op.getCustomer_name());
            ps.setString(3, op.getShip_address());
            ps.setString(4, op.getNotes());
            ps.setDouble(5, op.getTax());
            return ps;
          }  
        };
        int addOrder = template.update(psc, keyHolder);
        System.out.println("ADDED TO DATABASE, KEY IS:" + keyHolder.getKey() + keyHolder);


        //listRepo.leftPush("messages", op.toString());
        //leftPush("messages", op.toString());
        System.out.println("ADDED TO REDIS!" + op.toString());


        return keyHolder.getKey().intValue();
        } catch (Exception e) {

            throw new Exception("UNABLE TO WRITE ORDER TO DATABASE" + e.toString());
            // TODO: handle exception
        }
        


    }



    public void addDetail(OrderPage op) throws Exception{
        try {
            int added = template.update(Queries.SQL_DETAIL_INSERT, op.getProduct(), op.getUnit_price(), op.getDiscount(), op.getQuantity(), op.getOrder_id());
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("ORDER DETAILS COULD NOT BE WRITTEN TO DATABASE!");
        }
       
    }


/*     @Autowired
    @Qualifier("template01")
    RedisTemplate<String, String> redisTemplate;

    // slide 30, slide 34
    public void leftPush(String key, String value) {
        redisTemplate.opsForList().leftPush("messages", value);
    }
 */

    
    
}
