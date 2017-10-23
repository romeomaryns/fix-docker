package eu.maryns.fix.sink.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class LogSink {

    private static Logger logger = LoggerFactory.getLogger(LogSink.class);

    @StreamListener(Sink.INPUT)
    public void log(String message) {
        logger.info(message);
    }
}