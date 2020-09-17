package com.gnaw.springboot_rabbitmq.helloword;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-16 15:11
 **/
@RestController
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/hello/send")
    public void sendMessage(){
        rabbitTemplate.convertAndSend("hello", "test message");
    }
}
