package eu.maryns.fix.source.prices;

import com.oanda.v20.Context;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.pricing.PricingGetRequest;
import com.oanda.v20.pricing.PricingGetResponse;
import com.oanda.v20.primitives.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ComponentScan(value = "eu.maryns.fix.source.prices")
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
@EnableFeignClients
public class Application extends RepositoryRestConfigurerAdapter {

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Price.class);
    }

    @PostConstruct
    public void exposeIds() {
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Controller
    public static class SimplePriceController {
        @Autowired
        PriceRepository repository;


        @RequestMapping("/")
        @ResponseBody
        List<Price> getPrices() {
            Page<Price> all = repository.findAll(new PageRequest(0, 10));
            return all.getContent();
        }

        @RequestMapping("/load")
        @ResponseBody
        List<Price> loadPrices() {
            Context ctx = new Context(Config.URL, Config.TOKEN);
            AccountID accountId = Config.ACCOUNTID;
            List<String> instruments = new ArrayList<>(
                    Arrays.asList("EUR_USD", "USD_JPY", "GBP_USD", "USD_CHF"));

            // Poll for prices
            try {
                PricingGetRequest request = new PricingGetRequest(accountId, instruments);

                String in = "2017-01-01T00:00:00.000Z";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                DateTime since = new DateTime(in);

                request.setSince(since);
                PricingGetResponse resp = ctx.pricing.get(request);

                    for (com.oanda.v20.pricing.Price price : resp.getPrices()) {
                        System.out.println(price);
                        repository.save(new Price(price));
                    }

                } catch (Exception e1) {
                e1.printStackTrace();
            }
            Page<Price> all = repository.findAll(new PageRequest(0, 10));
            return all.getContent();
        }

    }
}
