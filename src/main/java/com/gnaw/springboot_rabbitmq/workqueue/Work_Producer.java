package com.gnaw.springboot_rabbitmq.workqueue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-rabbitmq2
 * @description:
 * @author: wang_sir
 * @create: 2020-09-16 15:32
 **/
@RestController
public class Work_Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/work/send")
    public void sendMessage(){
        rabbitTemplate.convertAndSend("work", "test workQueue");
    }
}
