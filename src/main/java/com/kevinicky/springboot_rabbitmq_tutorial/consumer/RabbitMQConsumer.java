package com.kevinicky.springboot_rabbitmq_tutorial.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQConsumer {

    @RabbitListener(queues = { "${rabbitmq.queue.name}" })
    private void consume(String message) {
        log.info("Received message -> {}", message);
    }

}
