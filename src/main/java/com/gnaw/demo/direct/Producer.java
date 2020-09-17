package com.gnaw.demo.direct;

import com.gnaw.util.ConnectionUtils;
import com.gnaw.util.Constant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @program: spring-boot-rabbitmq2
 * @description: 生产者
 * @author: wang_sir
 * @create: 2020-09-16 09:52
 **/
public class Producer {
    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Constant.EXANGE_NAME, "direct");
        channel.basicPublish(Constant.EXANGE_NAME, Constant.ROUTING_NAME_INFO, null, ("发送"+Constant.ROUTING_NAME_INFO+"信息").getBytes());
        ConnectionUtils.close(connection,channel);
    }
}
