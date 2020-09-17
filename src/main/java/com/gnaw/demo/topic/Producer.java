package com.gnaw.demo.topic;

import com.gnaw.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-16 14:46
 **/
public class Producer {
    public static void main(String[] args) throws IOException {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //创建交换机
        channel.exchangeDeclare("topic_logs", "topic");
        String routing_key="user.*";
        channel.basicPublish("topic_logs",routing_key,null,"today is exceeding delighted！".getBytes());
        ConnectionUtils.close(connection,channel);
    }
}
