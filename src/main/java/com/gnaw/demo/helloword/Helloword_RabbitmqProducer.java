package com.gnaw.demo.helloword;

import com.gnaw.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
/**
 * @program: spring-boot-rabbitmq2
 * @description: 生产者
 * @author: wang_sir
 * @create: 2020-09-15 20:07
 **/
public class Helloword_RabbitmqProducer {
    public static void main(String[] args)  {
        Connection connection = null;
        Channel channel = null;
        try {
            connection = ConnectionUtils.getConnection();
            channel = connection.createChannel();
            channel.queueDeclare("hello", false, false, false, null);
            //发布消息
            channel.basicPublish("", "hello", null,"helloRabbitMq".getBytes() );
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ConnectionUtils.close(connection,channel);
        }
    }
}
