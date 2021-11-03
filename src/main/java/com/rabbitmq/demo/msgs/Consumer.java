package com.rabbitmq.demo.msgs;

import com.rabbitmq.demo.model.UserStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "${spring.rabbit.queue.name}")
    public void consumerMsgsFromQueue(UserStatus status) {
        System.out.println("Message recieved from queue: " + status);
    }
}
