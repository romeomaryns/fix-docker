package eu.maryns.fix.sink.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author Dave Syer
 *
 */
@EnableBinding(Processor.class)
@ConfigurationProperties("module.logging")
public class LoggingTransformer {

    private static Logger logger = LoggerFactory.getLogger(LoggingTransformer.class);

    /**
     * The name to include in the log message
     */
    private String name = "logging";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Object payload) {
        String transformedString = "Transformed by " + this.name + ": " + payload;
        logger.info(transformedString);
        return transformedString;
    }

}