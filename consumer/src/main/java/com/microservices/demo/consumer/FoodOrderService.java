package com.microservices.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;

    private Double balance = 2000.0;

    @Autowired
    public FoodOrderService(FoodOrderRepository foodOrderRepository) {
        this.foodOrderRepository = foodOrderRepository;
    }

    public void persistFoodOrder(FoodOrder foodOrder) {
        Double money = foodOrder.getPrice() * foodOrder.getAmount();
        OrderStatus status = balance - money >= 0 ? OrderStatus.CONFIRMED : OrderStatus.CANCELLED;
        if (status.equals(OrderStatus.CONFIRMED)) {
            this.deduct(money);
        }
        foodOrder.setStatus(status);
        FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);
        log.info("food order persisted {}", persistedFoodOrder);
        log.info("count: {}", foodOrderRepository.findAll().size());
    }

    private void deduct(Double money) {
        this.balance = this.balance - money;
    }
}