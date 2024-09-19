package com.kevinicky.springboot_rabbitmq_tutorial.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kevinicky.springboot_rabbitmq_tutorial.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user) {
        log.info("Json message sent -> {}", user.toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, user);
    }
}
