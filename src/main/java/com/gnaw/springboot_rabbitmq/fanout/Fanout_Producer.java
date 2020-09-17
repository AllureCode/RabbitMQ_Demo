package com.gnaw.springboot_rabbitmq.fanout;

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
public class Fanout_Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("/fanout/send")
    public void send(){
        rabbitTemplate.convertAndSend("logs", "", "fanout 扇出");
    }
}
