package com.tg.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.order.model.Order;
import com.tg.order.service.OrderProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) {
        orderProducer.sendOrder(order);
        return "Order placed successfully!";
    }
}

