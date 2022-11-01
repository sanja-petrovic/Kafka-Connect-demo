package com.microservices.demo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    private final ObjectMapper objectMapper;
    private static final String requestsTopic = "${requests.topic.name}";

    public Consumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "requestsTopic", groupId = "consumer")
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);
        FoodOrderDto foodOrderDto = objectMapper.readValue(message, FoodOrderDto.class);
        FoodOrderRequest foodOrder = new FoodOrderRequest(foodOrderDto.getItem(), foodOrderDto.getAmount(), foodOrderDto.getPrice());
    }
}
