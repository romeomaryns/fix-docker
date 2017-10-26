package eu.maryns.fix.source.instruments;

import com.oanda.v20.Context;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.InstrumentName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
@EnableFeignClients
public class Application extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Candle.class);
    }

    @PostConstruct
    public void exposeIds() {
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Controller
    public static class CandleController {
        @Autowired
        CandleRepository repository;


        @RequestMapping("/")
        @ResponseBody
        List<Candle> getCandles() {
            Page<Candle> all = repository.findAll(new PageRequest(0, 10));
            return all.getContent();
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
                    }catch(Exception e)
                    {
                        System.out.println("ERROR during candle toString : " + e.getMessage());
                    }
                }
                } catch (Exception e1) {
                e1.printStackTrace();
            }
            return "Instruments Loaded ..";
        }

    }
}
