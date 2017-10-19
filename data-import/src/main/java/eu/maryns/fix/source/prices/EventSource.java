package eu.maryns.fix.source.prices;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableBinding(Source.class)
public class EventSource {

    public EventSource(RabbitTemplate rabbitTemplate, TopicExchange senderTopicExchange) {
    }

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT)
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>(new SimpleDateFormat().format(new Date()));
    }
}

