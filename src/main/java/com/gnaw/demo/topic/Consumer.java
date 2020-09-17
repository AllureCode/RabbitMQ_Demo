package com.gnaw.demo.topic;

import com.gnaw.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-16 14:51
 **/
public class Consumer {
    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        String queueName = channel.queueDeclare().getQueue();
        channel.exchangeDeclare("topic_logs","topic" );
        channel.queueBind(queueName, "topic_logs", "user.*");
        channel.basicConsume(queueName, true, (c, d)->{
           String message = new String(d.getBody(),"UTF-8");
            System.out.println(message);
        }, (c)->{});
    }
}
