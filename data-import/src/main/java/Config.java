import com.oanda.v20.account.AccountID;
import com.oanda.v20.primitives.InstrumentName;

/**
     * This is the configuration object used by the various examples to connect to
     * one of the OANDA trading systems.  Please fill them in with sane values.
     *
     * @param      URL         The fxTrade or fxPractice API URL
     * @param      TOKEN       The OANDA API Personal Access token
     * @param      ACCOUNTID   A valid v20 trading account ID that {@code TOKEN} has
     *                         permissions to take action on
     * @param      INSTRUMENT  A valid tradeable instrument for the given {@code
     *                         ACCOUNTID}
     * @author     gentili
 *
 *
 *
 * https://github.com/oanda/v20-java-samples/tree/master/src/main/java/com/oanda/v20/v20sample
 * http://developer.oanda.com/rest-live/streaming/
 * https://dzone.com/articles/event-driven-microservices-using-spring-cloud-stre
     */
    public class Config {
        private Config() {}
        public static final String URL = "https://api-fxpractice.oanda.com";
        public static final String TOKEN = "a87a45322aac965d815a76e69eeb1738-991d3a0e05efaf19cc582a08083cfbbd";
        public static final AccountID ACCOUNTID = new AccountID("101-004-6429306-001");
        public static final InstrumentName INSTRUMENT  = new InstrumentName("EUR/USD");
    }
