# **Kafka Messaging Service Demo**

This repository contains two microservices: **order-service** and **notification-service**, which demonstrate Kafka messaging. The **order-service** produces messages related to order creation, and the **notification-service** consumes those messages to send notifications (like email notifications).

## **Services**

### **1. Order Service**
The **order-service** is a microservice that produces Kafka messages when an order is created. It sends the order details to a Kafka topic.

- **Model**: `Order`
- **Producer Service**: `OrderProducer` - Sends `Order` objects to Kafka.
- **Controller**: `OrderController` - Provides a POST endpoint to create and send orders.

**Dependencies:**
- Lombok
- Spring Kafka
- Spring Web

**Endpoints:**
- **POST /orders**: Creates and sends an order to Kafka.

**Port:** 8081  
**Produces to Kafka Topic:** `order-topic`

### **2. Notification Service**
The **notification-service** is a microservice that consumes Kafka messages from the `order-topic`. Once an order message is consumed, it sends a notification, such as an email, to inform users about the order.

- **Consumer**: `NotificationConsumer` - Listens to Kafka topics and triggers the email-sending process.
- **Email Service**: `EmailService` - Handles sending simple emails.

**Dependencies:**
- Spring Kafka
- Spring Web

**Kafka Topics:**
- Consumes messages from the order-service topic to send notifications.

**Port:** 8082  
**Consumes from Kafka Topic:** `order-topic`

---

## **Local Setup and Testing**

### **Prerequisites**
**Ensure you have the following installed:**
- JDK 17 or later
- Apache Kafka
- Apache Zookeeper

### **Setting Up Kafka and Zookeeper**

Start Zookeeper: 
```bash
zookeeper-server-start.bat config/zookeeper.properties
```
Start Kafka:
kafka-server-start.bat config/server.properties

**Running the Services Locally**
    1. Clone the Repository
    2. Build and Run Order Service
    3. Build and Run Notification Service

**Kafka Topics Setup**
1. Create a Kafka Topic for Orders:
   kafka-topics.bat --create --topic <topic-name> --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1 
   (for our project topic-name is order-topic)

3. List Kafka Topics to Verify:
   kafka-topics.bat --list --bootstrap-server localhost:9092

### Note: 
**Run the commands with location of kafka like cd C:\kafka\ or cd C:\kafka\bin**

## Testing with SoapUI
Create a New Request:
    Set the request type to POST.
    Enter the URL for the Order Service endpoint, e.g., http://localhost:8081/orders.

Set Headers (if required):
    Content-Type: application/json

Set Body:
    Select raw and JSON format.
    Enter the JSON payload for the order:
    {
    "orderId" : "12380",
    "customerEmail" : "tgeetey@gmail.com",
    "orderDetails" : "Product XYZ"
    }

    Check Logs for services to check on the workflow.

    Feel free to adjust URLs and other details based on your specific setup and requirements, I will try to add integration tests if required. If you have any more questions or need further adjustments, let me know!
