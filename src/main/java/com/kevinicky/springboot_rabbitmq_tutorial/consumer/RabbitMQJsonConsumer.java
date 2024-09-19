package com.kevinicky.springboot_rabbitmq_tutorial.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.kevinicky.springboot_rabbitmq_tutorial.dto.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = { "${rabbitmq.queue.json.name}" })
    private void consumeJsonMessage(User user) {
        log.info("Receive json message -> {}", user.toString());
    }
}
