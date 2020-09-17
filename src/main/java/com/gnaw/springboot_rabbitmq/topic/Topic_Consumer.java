package com.gnaw.springboot_rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-16 15:47
 **/
@Component
public class Topic_Consumer {

    @RabbitListener(bindings =
            {@QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(
                            value = "topic",
                            type = "topic"),
                    key = {"info.*"}
            )
            })
    public void received(String message){
        System.out.println("consumer1"+message);
    }

    @RabbitListener(bindings =
            {@QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(
                            value = "topic",
                            type = "topic"),
                    key = {"info.#","*.*.info"}
            )
            })
    public void received2(String message){
        System.out.println("consumer2"+message);
    }
}
