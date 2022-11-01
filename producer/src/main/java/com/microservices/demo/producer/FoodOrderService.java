package com.microservices.demo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FoodOrderService {

    private final Producer producer;
    private final FoodOrderRequestRepository repository;

    @Autowired
    public FoodOrderService(Producer producer, FoodOrderRequestRepository repository) {
        this.producer = producer;
        this.repository = repository;
    }

    public void createFoodOrder(FoodOrderRequestDto dto) throws JsonProcessingException {
        producer.sendMessage(dto);
        FoodOrderRequest request = new FoodOrderRequest(dto.getItem(), dto.getAmount(), dto.getPrice());
        repository.save(request);
    }

    public List<FoodOrderRequest> getRequests() {
        return repository.findAll();
    }
}