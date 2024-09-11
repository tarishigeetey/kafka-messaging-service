**Kafka Messaging Service**

This repository contains two microservices: order-service and notification-service, which demonstrate Kafka messaging. The order-service produces messages related to order creation, and the notification-service consumes those messages to send notifications (like email notifications).

**Services**

*1. Order Service*
The order-service is a microservice that produces Kafka messages when an order is created. It sends the order details to a Kafka topic.

Port: 8080
Produces to Kafka Topic: order-topic

*2. Notification Service*
The notification-service is a microservice that consumes Kafka messages from the order-topic. Once an order message is consumed, it sends a notification, such as an email, to inform users about the order.

Port: 8081
Consumes from Kafka Topic: order-topic
