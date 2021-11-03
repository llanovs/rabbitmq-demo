package com.rabbitmq.demo.controller;

import com.rabbitmq.demo.model.UserDto;
import com.rabbitmq.demo.model.UserStatus;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RabbitMqController {

    @Autowired
    private AmqpTemplate template;

    @PostMapping("/send")
    public String send(@RequestBody UserDto user) {
        user.setId(UUID.randomUUID().toString());
        UserStatus userStatus = new UserStatus(user, "TEXTING", "User texting msgs");
        template.convertAndSend(userStatus);
        return "Event published";
    }
}
