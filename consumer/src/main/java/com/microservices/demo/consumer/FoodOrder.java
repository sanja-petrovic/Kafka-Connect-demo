package com.microservices.demo.consumer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String item;
    @Column
    private Double amount;
    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column
    private Double price;

    public FoodOrder(String item, Double amount, Double price) {
        this.item = item;
        this.amount = amount;
        this.price = price;
        this.status = OrderStatus.PROCESSING;
    }
}