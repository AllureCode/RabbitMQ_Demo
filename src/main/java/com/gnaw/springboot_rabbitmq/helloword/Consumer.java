package com.gnaw.springboot_rabbitmq.helloword;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-16 15:24
 **/
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class Consumer {

    @RabbitHandler
    public void received(String message){
        System.out.println(message);
    }
}
