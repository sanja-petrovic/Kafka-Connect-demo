package com.microservices.demo.consumer;
import lombok.Data;
import lombok.Value;

@Data
@Value
public class FoodOrderDto {
    Long id;
    String item;
    Double amount;
    Double price;
}