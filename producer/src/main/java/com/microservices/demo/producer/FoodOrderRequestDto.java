package com.microservices.demo.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderRequestDto {
    private String item;
    private Double amount;
    private Double price;
}
