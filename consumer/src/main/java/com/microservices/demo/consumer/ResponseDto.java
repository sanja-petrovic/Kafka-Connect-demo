package com.microservices.demo.consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDto {
    private Long id;
    private OrderStatus status;
    private String replyChannel;
}
