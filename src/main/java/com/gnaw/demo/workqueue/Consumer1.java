package com.gnaw.demo.workqueue;

import com.gnaw.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-15 21:39
 **/
public class Consumer1 {
    public static void main(String[] args) {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel =null;
        try {
            channel = connection.createChannel();
            channel.queueDeclare("work", false, false, false,null);
          //  void handle(String consumerTag, Delivery message) throws IOException;
            DeliverCallback  deliverCallback  = ( consumerTag, message)->{
                String message1 = new String(message.getBody(), "UTF-8");
                System.out.println("Consumer1 Received Message---->"+message1);
            };
            channel.basicConsume("work", true,deliverCallback,(consumerTag) ->{ } );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
