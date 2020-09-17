package com.gnaw.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-15 19:31
 **/
public class ConnectionUtils {

    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("59.74.109.248");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/shopping");
    }
    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtils.getConnection();
        System.out.println(connection);
        connection.close();
    }

    /**
     * 连接工具类
     *
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection getConnection() {

        try {
            return  connectionFactory.newConnection();
        } catch (IOException | TimeoutException e) {
          return null;
        }
    }

    public static void close(Connection connection, Channel channel){

            try {
                connection.close();
                channel.close();
            } catch (IOException | TimeoutException e) {
                e.printStackTrace();
            }
        }
}
