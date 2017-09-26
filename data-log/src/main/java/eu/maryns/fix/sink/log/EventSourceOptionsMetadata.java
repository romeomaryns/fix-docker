package eu.maryns.fix.sink.log;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@ConfigurationProperties
public class EventSourceOptionsMetadata {

    /**
     * 	how to render the current time, using SimpleDateFormat
     */
    private String format = "yyyy-MM-dd HH:mm:ss";

    /**
     * time delay between messages, expressed in TimeUnits (seconds by default)
     */
    private int fixedDelay = 1;

    /**
     * an initial delay when using a fixed delay trigger, expressed in TimeUnits (seconds by default)
     */
    private int initialDelay = 0;

    /**
     * the time unit for the fixed and initial delays
     */
    private String timeUnit = "SECONDS";

    /**
     * the maximum messages per poll; -1 for unlimited
     */
    long maxMessages = 1;

    public long getMaxMessages() {
        return this.maxMessages;
    }

    public void setMaxMessages(long maxMessages) {
        this.maxMessages = maxMessages;
    }

    @Min(0)
    public int getInitialDelay() {
        return this.initialDelay;
    }

    public void setInitialDelay(int initialDelay) {
        this.initialDelay = initialDelay;
    }

    @Pattern(regexp = "(?i)(NANOSECONDS|MICROSECONDS|MILLISECONDS|SECONDS|MINUTES|HOURS|DAYS)",
            message = "timeUnit must be one of NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS (case-insensitive)")
    public String getTimeUnit() {
        return this.timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit.toUpperCase();
    }

    @DateFormat
    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getFixedDelay() {
        return this.fixedDelay;
    }

    public void setFixedDelay(int fixedDelay) {
        this.fixedDelay = fixedDelay;
    }
}
