package com.gnaw.springboot_rabbitmq.direct;

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
public class Direct_Consumer {

    @RabbitListener(bindings =
            {@QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(
                            value = "direct",
                            type = "direct"),
                    key = {"info"}
            )
            })
    public void received(String message){
        System.out.println("consumer1"+message);
    }

    @RabbitListener(bindings =
            {@QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(
                            value = "direct",
                            type = "direct"),
                    key = {"error","waring"}
            )
            })
    public void received2(String message){
        System.out.println("consumer2"+message);
    }
}
