package com.gnaw.demo.fanout;

import com.gnaw.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @program: spring-boot-rabbitmq2
 * @description: 生产者
 * @author: wang_sir
 * @create: 2020-09-16 09:18
 **/
public class Producer {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs", "fanout");
        channel.basicPublish("logs", "", null,"who are you".getBytes());
        ConnectionUtils.close(connection,channel);
    }
}
