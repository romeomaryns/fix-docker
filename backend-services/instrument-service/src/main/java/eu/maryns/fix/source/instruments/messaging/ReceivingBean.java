package eu.maryns.fix.source.instruments.messaging;


import eu.maryns.fix.source.instruments.contract.InstrumentView;
import eu.maryns.fix.source.instruments.model.Instrument;
import eu.maryns.fix.source.instruments.repository.InstrumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Processor.class)
public class ReceivingBean {

    @Autowired
    InstrumentRepository repository;

    private Logger log = LoggerFactory.getLogger(ReceivingBean.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Instrument handle(InstrumentView instrument) {
        log.info("handle Instrument : " + instrument.toString());
        return repository.save(new Instrument(instrument));
    }
}
