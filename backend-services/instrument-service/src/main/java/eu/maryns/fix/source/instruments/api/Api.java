package eu.maryns.fix.source.instruments.api;

import com.oanda.v20.Context;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.account.AccountInstrumentsRequest;
import com.oanda.v20.account.AccountInstrumentsResponse;
import eu.maryns.fix.source.instruments.config.Config;
import eu.maryns.fix.source.instruments.model.Instrument;
import eu.maryns.fix.source.instruments.repository.InstrumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class Api {

    private List<Instrument> instruments;

    protected static Logger logger = LoggerFactory.getLogger(Api.class.getName());


    @Autowired
    InstrumentRepository repository;

    public Api() {
        instruments = new ArrayList<>();
        try {
            instruments.addAll((Collection<? extends Instrument>) repository.findAll());
        }catch (Exception e){
            System.out.println("failed to fill instrument collection on startup.. " +e.getMessage());
        }
    }


    @RequestMapping("/pagedInstruments")
    @ResponseBody
    List<Instrument> getInstruments() {
        Page<Instrument> all = repository.findAll(new PageRequest(0, 10));
        return all.getContent();
    }

    @RequestMapping("/load")
    @ResponseBody
    String loadInstruments() {
        Context ctx = new Context(Config.URL, Config.TOKEN);
        AccountID accountId = Config.ACCOUNTID;

        // Poll for prices
        try {
            AccountInstrumentsRequest request = new AccountInstrumentsRequest(accountId);
            AccountInstrumentsResponse resp = ctx.account.instruments(request);
            for(com.oanda.v20.primitives.Instrument instrument : resp.getInstruments()){
                try {
                    System.out.println(instrument.toString());
                    System.out.println("\t" + instrument.getDisplayName());
                    System.out.println("\tCommision = " + instrument.getCommission());
                    System.out.println("\tPrecision = " + instrument.getDisplayPrecision());
                    System.out.println("\tMarginRate = " + instrument.getMarginRate());
                    System.out.println("\tMaximumOrderUnits = " + instrument.getMaximumOrderUnits());
                    System.out.println("\tMaximumPositionSize = " + instrument.getMaximumPositionSize());
                    System.out.println("\tMaximumTrailingStopDistance = " + instrument.getMaximumTrailingStopDistance());
                    System.out.println("\tMinimumTradeSize = " + instrument.getMinimumTradeSize());
                    System.out.println("\tMinimumTrailingStopDistance = " + instrument.getMinimumTrailingStopDistance());
                    System.out.println("\tName = " + instrument.getName());
                    System.out.println("\tPipLocation = " + instrument.getPipLocation());
                    System.out.println("\tTradeUnitsPrecision = " + instrument.getTradeUnitsPrecision());
                    System.out.println("\tType = " + instrument.getType());
                    repository.save(new Instrument(instrument));
                }catch(Exception e)
                {
                    System.out.println("ERROR during Instrument toString : " + e.getMessage());
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "Instruments Loaded ..";
    }

    @RequestMapping("/{name}")
    public Instrument findByName(@PathVariable("name") String name) {
        logger.info(String.format("Instrument.findByName(%s)", name));
        Instrument a = instruments.stream().filter(it -> it.getName().equals(name)).findFirst().get();
        logger.info(String.format("Instrument.findByName: %s", a));
        return a;
    }

    @RequestMapping("/")
    public List<Instrument> findAll() {
        logger.info("Instrument.findAll()");
        logger.info(String.format("Instrument.findAll: %s",instruments));
        return instruments;
    }
}
