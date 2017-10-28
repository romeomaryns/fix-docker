package eu.maryns.fix.source.candles.api;

import com.oanda.v20.Context;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.InstrumentName;
import eu.maryns.fix.source.candles.config.Config;
import eu.maryns.fix.source.candles.model.Candle;
import eu.maryns.fix.source.candles.model.CandleStickGranularity;
import eu.maryns.fix.source.candles.repository.CandleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Api {

    private List<Candle> candles;

    protected static Logger logger = LoggerFactory.getLogger(Api.class.getName());


    @Autowired
    CandleRepository repository;

    public Api() {
        candles = new ArrayList<>();
        try {
            candles.addAll((Collection<? extends Candle>) repository.findAll());
        }catch (Exception e){
            System.out.println("failed to fill candle collection on startup.. " +e.getMessage());
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    HttpEntity<PagedResources<Candle>> candles(Pageable pageable,
                                               PagedResourcesAssembler assembler) {

        Page<Candle> candles = repository.findAll(pageable);
        return new ResponseEntity<>((MultiValueMap<String, String>) assembler.toResource(candles), HttpStatus.OK);
    }
   /* List<Candle> getCandlesPaged() {
        Page<Candle> all = repository.findAll(new PageRequest(0, 10));
        return all.getContent();
    }*/

    @RequestMapping("/test")
    @ResponseBody
    List<Candle> getCandles() {
        logger.info("Candle.findAll()");
        logger.info(String.format("Candle.findAll: %s",candles));
        candles.clear();
        candles.addAll((Collection<? extends Candle>) repository.findAll());
        return candles;
    }

    @RequestMapping("/load")
    @ResponseBody
    String loadCandles() {
        Context ctx = new Context(Config.URL, Config.TOKEN);
        AccountID accountId = Config.ACCOUNTID;
        String instrument = "EUR_USD";
        String in = "2017-01-01T00:00:00.000Z";
        CandlestickGranularity granularity = CandlestickGranularity.D;

        // Poll for prices
        try {
            InstrumentCandlesRequest request = new InstrumentCandlesRequest(new InstrumentName(instrument));
            request.setFrom(in);
            request.setGranularity(granularity);
            InstrumentCandlesResponse resp = ctx.instrument.candles(request);
            for(Candlestick candle : resp.getCandles()){
                try {
                    System.out.println(candle.toString());
                    System.out.println("\t" + candle.getTime());
                    System.out.println("\t" + ((candle.getMid() == null) ? "NO MID" : candle.getMid()));
                    System.out.println("\tC = " + ((candle.getMid().getC() == null) ? "NO MID" : candle.getMid().getC()));
                    System.out.println("\tH = " + ((candle.getMid().getH() == null) ? "NO MID" : candle.getMid().getH()));
                    System.out.println("\tL = " + ((candle.getMid().getL() == null) ? "NO MID" : candle.getMid().getL()));
                    System.out.println("\tO = " + ((candle.getMid().getO() == null) ? "NO MID" : candle.getMid().getO()));
                    System.out.println("\t" + candle.getVolume());
                    repository.save(new Candle(candle,resp.getInstrument().toString(), CandleStickGranularity.valueOf(resp.getGranularity().name())));
                }catch(Exception e)
                {
                    System.out.println("ERROR during candle toString : " + e.getMessage());
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "Candles Loaded ..";
    }
}
