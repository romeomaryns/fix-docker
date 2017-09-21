package eu.maryns.fix.publisher;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class EventPublisher {

    private final RabbitTemplate rabbitTemplate;

    private final Exchange exchange;

    public EventPublisher(RabbitTemplate rabbitTemplate, Exchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void createApiCall() {
        // ... do some database stuff
        String routingKey = "customer.created";
        String message = "customer created";
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
    }
}

