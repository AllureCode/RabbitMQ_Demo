package com.gnaw.springboot_rabbitmq.workqueue;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-16 15:34
 **/

@Component
public class Work_Consumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive(String message)   {
        System.out.println("consumer1"+message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message)  {
        System.out.println("consumer2"+message);
    }
}
