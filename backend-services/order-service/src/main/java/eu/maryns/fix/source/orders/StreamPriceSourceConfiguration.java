package eu.maryns.fix.source.orders;


import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class StreamPriceSourceConfiguration {

    @Bean
    public TopicExchange senderTopicExchange() {
        return new TopicExchange("log");
    }


    @Bean
    public StreamPriceSource eventPublisher(RabbitTemplate rabbitTemplate, TopicExchange senderTopicExchange) {
        return new StreamPriceSource(rabbitTemplate, senderTopicExchange);
    }

}