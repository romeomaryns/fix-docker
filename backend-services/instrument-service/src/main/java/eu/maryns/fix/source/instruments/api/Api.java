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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequestMapping("/instruments")
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
            logger.error("failed to fill instrument collection on startup.. " ,e);
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
        logger.info("loadInstruments . . .");
        Context ctx = new Context(Config.URL, Config.TOKEN);
        AccountID accountId = Config.ACCOUNTID;

        // Poll for prices
        try {
            AccountInstrumentsRequest request = new AccountInstrumentsRequest(accountId);
            AccountInstrumentsResponse resp = ctx.account.instruments(request);
            for(com.oanda.v20.primitives.Instrument instrument : resp.getInstruments()){
                try {
                    logger.info(instrument.toString());
                    logger.info("\t" + instrument.getDisplayName());
                    logger.info("\tCommision = " + instrument.getCommission());
                    logger.info("\tPrecision = " + instrument.getDisplayPrecision());
                    logger.info("\tMarginRate = " + instrument.getMarginRate());
                    logger.info("\tMaximumOrderUnits = " + instrument.getMaximumOrderUnits());
                    logger.info("\tMaximumPositionSize = " + instrument.getMaximumPositionSize());
                    logger.info("\tMaximumTrailingStopDistance = " + instrument.getMaximumTrailingStopDistance());
                    logger.info("\tMinimumTradeSize = " + instrument.getMinimumTradeSize());
                    logger.info("\tMinimumTrailingStopDistance = " + instrument.getMinimumTrailingStopDistance());
                    logger.info("\tName = " + instrument.getName());
                    logger.info("\tPipLocation = " + instrument.getPipLocation());
                    logger.info("\tTradeUnitsPrecision = " + instrument.getTradeUnitsPrecision());
                    logger.info("\tType = " + instrument.getType());
                    repository.save(new Instrument(instrument));
                }catch(Exception e)
                {
                    logger.error("ERROR during Instrument toString : " , e);
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "Instruments Loaded ..";
    }

    @RequestMapping("/{id}")
    public Instrument findById(@PathVariable("id")Long id) {
        logger.info(String.format("Instrument.findById(%s)", id));
        return repository.findById(id).get();
    }

    @RequestMapping("/")
    public List<Instrument> findAll() {
        logger.info("Instrument.findAll()");
        logger.info(String.format("Instrument.findAll: %s",instruments));
        instruments.clear();
        repository.findAll().forEach(instrument -> instruments.add(instrument));
        return instruments;
    }
}
