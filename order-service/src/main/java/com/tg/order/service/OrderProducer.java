package com.tg.order.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tg.order.model.Order;

@Service
public class OrderProducer {
	private final KafkaTemplate<String, Order> kafkaTemplate;  // Updated to Order

	public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendOrder(Order order) {
		// Send the Order object directly
		kafkaTemplate.send("order-topic", order);
	}
}
