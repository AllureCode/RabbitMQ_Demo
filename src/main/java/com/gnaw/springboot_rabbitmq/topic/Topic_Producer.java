package com.gnaw.springboot_rabbitmq.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-16 15:47
 **/
@RestController
public class Topic_Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("/topic/send")
    public void send(){
        rabbitTemplate.convertAndSend("topic", "info.in", "topic********");
    }
}
