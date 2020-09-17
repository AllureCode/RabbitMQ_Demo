package com.gnaw.demo.helloword;

import com.gnaw.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @program: spring-boot-rabbitmq2
 * @description: 消费者
 * @author: wang_sir
 * @create: 2020-09-15 20:21
 **/
public class Helloword_RabbitmqConsumer {
    public static void main(String[] args) {
        Connection connection = null;
        Channel channel = null;
        try {
            connection = ConnectionUtils.getConnection();
            channel = connection.createChannel();
            channel.queueDeclare("hello", false, false, false, null);
            //消费消息
           // void handle(String consumerTag, Delivery message) throws IOException;
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" Received Message--->'" + message + "'");
            };
            channel.basicConsume("hello", true, deliverCallback, consumerTag -> { });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
