package com.gnaw.springboot_rabbitmq.direct;

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
public class Direct_Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("/direct/send")
    public void send(){
        rabbitTemplate.convertAndSend("direct", "info", "direct********");
    }
}
