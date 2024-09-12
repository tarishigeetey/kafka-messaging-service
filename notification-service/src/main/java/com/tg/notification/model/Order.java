package com.tg.notification.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private String orderId;
    private String customerEmail;
    private String orderDetails;
    
    @JsonCreator
    public Order(@JsonProperty("orderId") String orderId,
                 @JsonProperty("customerEmail") String customerEmail,
                 @JsonProperty("orderDetails") String orderDetails) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.orderDetails = orderDetails;
    }
}
