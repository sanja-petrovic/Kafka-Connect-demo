package com.microservices.demo.producer;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String item;
    @Column
    private Double amount;
    @Column
    private Double price;
    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public FoodOrderRequest(String item, Double amount, Double price) {
        this.item = item;
        this.amount = amount;
        this.price = price;
        this.status = OrderStatus.PROCESSING;
    }
}