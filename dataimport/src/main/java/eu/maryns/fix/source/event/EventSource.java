package eu.maryns.fix.source.event;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableBinding(Source.class)
@EnableConfigurationProperties(EventSourceOptionsMetadata.class)
public class EventSource {

    @Autowired
    private EventSourceOptionsMetadata options;

    @InboundChannelAdapter(value = Source.OUTPUT)
    public String eventMessageSource() {
        return new SimpleDateFormat(this.options.getFormat()).format(new Date());
    }

}

