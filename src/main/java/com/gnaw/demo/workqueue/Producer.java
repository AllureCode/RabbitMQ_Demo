package com.gnaw.demo.workqueue;

import com.gnaw.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @program: spring-boot-rabbitmq2
 * @description: 生产者
 * @author: wang_sir
 * @create: 2020-09-15 21:32
 **/
public class Producer {
    public static void main(String[] args) {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel =null;
        try {
             channel = connection.createChannel();
            channel.queueDeclare("work", false, false, false,null);
            for (int i = 1; i <=20 ; i++) {
                channel.basicPublish("","work",null,(i+"号---->message").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtils.close(connection,channel);
        }
    }
}
