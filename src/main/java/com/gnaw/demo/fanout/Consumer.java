package com.gnaw.demo.fanout;

import com.gnaw.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @program: spring-boot-rabbitmq2
 * @description: 消费者
 * @author: wang_sir
 * @create: 2020-09-16 09:18
 **/
public class Consumer {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs", "fanout");
        String temporaryQueue = channel.queueDeclare().getQueue();
        channel.queueBind(temporaryQueue, "logs", "");

        channel.basicConsume(temporaryQueue, true, (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Consumer1 Received Message---->" + message);
        }, (consumer) -> {
        });

    }
}
