package eu.maryns.fix.sink.log;

import com.oanda.v20.pricing.Price;
import com.oanda.v20.pricing.PricingGetRequest;
import com.oanda.v20.pricing.PricingGetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dave Syer
 *
 */
@EnableBinding(Sink.class)
@ConfigurationProperties("prices")
public class PricesPersister {
    @ServiceActivator(inputChannel=Sink.INPUT)
    public void persist(Object payload) {
        String pricesJSON = (String) payload;
        System.out.println(pricesJSON);
     //   RestTemplate restTemplate = new RestTemplate();
     //   String request = restTemplate.getForObject(pricesJSON, PricingGetRequest.class);
    //    System.out.println("JSON PRices number ; " + request.getPrices().size());
    }

}