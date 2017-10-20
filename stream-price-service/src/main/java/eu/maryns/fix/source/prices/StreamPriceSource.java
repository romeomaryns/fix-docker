package eu.maryns.fix.source.prices;

import com.oanda.v20.Context;
import com.oanda.v20.ExecuteException;
import com.oanda.v20.RequestException;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.pricing.Price;
import com.oanda.v20.pricing.PricingGetRequest;
import com.oanda.v20.pricing.PricingGetResponse;
import com.oanda.v20.primitives.DateTime;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@EnableBinding(Source.class)
public class StreamPriceSource {

    public StreamPriceSource(RabbitTemplate rabbitTemplate, TopicExchange senderTopicExchange) {
    }


    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT)
    public MessageSource<List<Price>> send() {
            System.out.println("Sending message...");
        Context ctx = new Context(Config.URL, Config.TOKEN);
        AccountID accountId = Config.ACCOUNTID;
        List<String> instruments = new ArrayList<>(
                Arrays.asList("EUR_USD", "USD_JPY", "GBP_USD", "USD_CHF"));

            PricingGetRequest request = new PricingGetRequest(accountId, instruments);

        PricingGetResponse resp = null;
        try {
            resp = ctx.pricing.get(request);
        } catch (RequestException e) {
            e.printStackTrace();
        } catch (ExecuteException e) {
            e.printStackTrace();
        }
        ArrayList<Price> prices = new ArrayList<Price>();
        for (Price price : resp.getPrices()) {
                    System.out.println(price.getTime().toString() + price.getInstrument().toString());
                    prices.add(price);
                }
        return () -> new GenericMessage<List<Price>>(prices);
    }

}