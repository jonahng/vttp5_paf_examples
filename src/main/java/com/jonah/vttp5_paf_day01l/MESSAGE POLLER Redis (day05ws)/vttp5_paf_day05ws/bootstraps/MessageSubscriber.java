package com.jonah.vttp5_paf_day05ws.bootstraps;

import java.util.Date;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber implements MessageListener {

   @Override
   public void onMessage(Message msg, byte[] pattern) {

      String pat = new String(pattern);
      String body = new String(msg.getBody());

      System.out.printf(">>>> MESSAGE: %s %s %s\n",
            new Date(), pat, body);
   }

}
