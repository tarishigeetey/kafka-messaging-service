package com.tg.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tg.order.model.Order;

@Service
public class NotificationConsumer {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void consume(Order order) {
        // Send email to the customer
        String emailMessage = String.format("Dear Customer, your order %s has been placed successfully!", order.getOrderId());
        emailService.sendSimpleMessage(order.getCustomerEmail(), "Order Confirmation", emailMessage);
        System.out.println("Email sent to " + order.getCustomerEmail());
    }
}
