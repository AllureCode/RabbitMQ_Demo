package com.gnaw.demo.direct;

import com.gnaw.util.ConnectionUtils;
import com.gnaw.util.Constant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @program: spring-boot-rabbitmq2
 * @description: 消费者
 * @author: wang_sir
 * @create: 2020-09-16 09:52
 **/
public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        String queueName = channel.queueDeclare().getQueue();
        channel.exchangeDeclare(Constant.EXANGE_NAME, "direct");
        channel.queueBind(queueName, Constant.EXANGE_NAME, Constant.ROUTING_NAME_ERROR);
        channel.basicConsume(queueName, true, (consumerTag,delivy)->{
            String message = new String(delivy.getBody());
            System.out.println("Consumer Received Message---->" + message);
        },(consumer)->{});
    }
}
