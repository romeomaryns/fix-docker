package eu.maryns.fix.source.instruments.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface InstrumentChannels {

    @Input("instruments-saved")
    public SubscribableChannel savedInstruments();

    @Output("instruments-to-save")
    MessageChannel instruments();

    @Output("commands")
    MessageChannel commands();
}
