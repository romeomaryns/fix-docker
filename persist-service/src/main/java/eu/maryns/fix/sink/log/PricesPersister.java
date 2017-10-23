package eu.maryns.fix.sink.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.oanda.v20.pricing.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@EnableBinding(Sink.class)
@ConfigurationProperties("prices")
public class PricesPersister {

  //  @Autowired
   // PriceRepository priceRepository;

    @ServiceActivator(inputChannel=Sink.INPUT)
    public void persist(Object payload) {
        String pricesJSON = (String) payload;
        System.out.println(pricesJSON);

        Gson gson = new GsonBuilder().create();

        PricesJSON priceList = new PricesJSON();
        try {
            priceList = gson.fromJson(pricesJSON, PricesJSON.class);
        }
        catch(Exception e)
        {
            System.out.println("Error parsing json .. " + e.getMessage());
        }
        System.out.println(priceList);
      /*  for(PriceJSON price :priceList.getPricesList())
        {
            if(null != price)
            {
      //          priceRepository.save(price);
                System.out.println("SUCCESS !!!!!!!!!!");
            }
        }*/
    }

}