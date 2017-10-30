package eu.maryns.fix.oanda.api;


import com.oanda.v20.Context;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.account.AccountInstrumentsRequest;
import com.oanda.v20.account.AccountInstrumentsResponse;
import com.oanda.v20.primitives.Instrument;
import eu.maryns.fix.oanda.binding.InstrumentChannels;
import eu.maryns.fix.oanda.config.Config;
import eu.maryns.fix.oanda.model.InstrumentView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instruments")
@EnableBinding(InstrumentChannels.class)
public class InstrumentController {

    Context ctx = new Context(Config.URL, Config.TOKEN);
    AccountID accountId = Config.ACCOUNTID;

    private MessageChannel outputInstruments;
    private SubscribableChannel inputInstruments;
    private List<InstrumentView> instruments ;
    private Logger log = LoggerFactory.getLogger(InstrumentController.class);

    @Autowired
    public InstrumentController(@Qualifier("instruments-to-save") MessageChannel outputInstruments
    , @Qualifier("instruments-saved")SubscribableChannel inputInstruments) {
        this.outputInstruments = outputInstruments;
        this.inputInstruments = inputInstruments;
        instruments =  new ArrayList<InstrumentView>();
    }


    @RequestMapping(method = RequestMethod.GET)
    List<InstrumentView> getInstruments() {

        try {
            AccountInstrumentsRequest request = new AccountInstrumentsRequest(accountId);
            AccountInstrumentsResponse response = ctx.account.instruments(request);


            for (Instrument instrument : response.getInstruments()) {
                try {
                    instruments.add(new InstrumentView(instrument));
                }
                catch(Exception e)
                {
                    log.error("error tijdens toevoegen instrumentViews", e);
                }
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        this.outputInstruments.send(MessageBuilder.withPayload(instruments).build());
        return instruments;
    }


    @StreamListener("instruments-saved")
    public void handle(InstrumentView instrument) {
        log.info("handling instrument : " + instrument);
        this.instruments.add(instrument);log.info("instruments size : " + instruments.size());
    }

}
