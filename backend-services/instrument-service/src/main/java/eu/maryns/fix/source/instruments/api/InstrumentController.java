package eu.maryns.fix.source.instruments.api;


import com.oanda.v20.Context;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.account.AccountInstrumentsRequest;
import com.oanda.v20.account.AccountInstrumentsResponse;
import eu.maryns.fix.source.instruments.binding.InstrumentChannels;
import eu.maryns.fix.source.instruments.config.Config;
import eu.maryns.fix.source.instruments.model.Instrument;
import eu.maryns.fix.source.instruments.model.InstrumentCommission;
import eu.maryns.fix.source.instruments.service.InstrumentCommissionService;
import eu.maryns.fix.source.instruments.service.InstrumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/command")
@EnableBinding(InstrumentChannels.class)
public class InstrumentController {

    Context ctx = new Context(Config.URL, Config.TOKEN);
    AccountID accountId = Config.ACCOUNTID;

    private MessageChannel outputInstruments;
    private SubscribableChannel inputInstruments;
    private List<Instrument> instruments ;
    private Logger log = LoggerFactory.getLogger(InstrumentController.class);

    @Autowired
    private InstrumentService instrumentService;

    @Autowired
    private InstrumentCommissionService instrumentCommissionService;

    @Autowired
    public InstrumentController(
            @Qualifier("instruments-to-save") MessageChannel outputInstruments
            ,@Qualifier("instruments-saved")SubscribableChannel inputInstruments) {
        this.outputInstruments = outputInstruments;
        this.inputInstruments = inputInstruments;
        instruments =  new ArrayList<Instrument>();
    }


    @RequestMapping(value = "load",method = RequestMethod.GET)
    public ModelAndView getInstruments() {

        try {
            AccountInstrumentsRequest request = new AccountInstrumentsRequest(accountId);
            AccountInstrumentsResponse response = ctx.account.instruments(request);


            for (com.oanda.v20.primitives.Instrument instrument : response.getInstruments()) {
                try {
                   // instruments.add(instrument);
                    //this.outputInstruments.send(MessageBuilder.withPayload(new Instrument(instrument)).build());
                    Instrument instrumentObject = new Instrument(instrument);
                    try {
                        instrumentObject.setCommission(new InstrumentCommission(instrument.getCommission()));
                    }catch(Exception e)
                    {
                        log.error("Error tijdens toevoegen commissie : " , e);
                    }
                    instrumentService.save(instrumentObject);
                }
                catch(Exception e)
                {
                    log.error("error tijdens toevoegen instruments", e);
                }
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        return new ModelAndView("redirect:" + "instruments");
    }

    @RequestMapping(value = "clean" ,method = RequestMethod.GET)
    public String clean(){
        instrumentService.clean();
        instrumentCommissionService.clean();
        return "Cleaned";
    }
}
