package com.microservices.demo.producer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderDto {
    private String item;
    private Double amount;
    private Double price;
    private Long id;
}
