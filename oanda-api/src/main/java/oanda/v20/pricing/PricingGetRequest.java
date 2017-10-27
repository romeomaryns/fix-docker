package oanda.v20.pricing;

import java.util.ArrayList;
import java.util.Collection;

import oanda.v20.Request;
import oanda.v20.account.AccountID;
import oanda.v20.primitives.DateTime;
import oanda.v20.primitives.InstrumentName;

/**
 * PricingGetRequest
 */
public class PricingGetRequest extends Request {

    /**
     * PricingGetRequest Constructor
     * <p>
     * Construct a new PricingGetRequest
     * <p>
     * @param accountID Account Identifier
     * @param instruments List of Instruments to get pricing for.
     */
    public PricingGetRequest(AccountID accountID, Collection<?> instruments) {
        this.setPathParam("accountID", accountID);
        ArrayList<InstrumentName> newInstruments = new ArrayList<InstrumentName>(instruments.size());
        instruments.forEach((item) -> {
            if (item instanceof InstrumentName)
            {
                newInstruments.add((InstrumentName) item);
            }
            else if (item instanceof String)
            {
                newInstruments.add(new InstrumentName((String) item));
            }
            else
            {
                throw new IllegalArgumentException(
                    item.getClass().getName() + " cannot be converted to an InstrumentName"
                );
            }
        });
        this.setQueryParam("candles", newInstruments);

    }

    /**
     * Set the candles
     * <p>
     * List of Instruments to get pricing for.
     * <p>
     * @param instruments the candles
     * @return {@link PricingGetRequest PricingGetRequest}
     * @see InstrumentName
     */
    public PricingGetRequest setInstruments(Collection<?> instruments) {
        ArrayList<InstrumentName> newInstruments = new ArrayList<InstrumentName>(instruments.size());
        instruments.forEach((item) -> {
            if (item instanceof InstrumentName)
            {
                newInstruments.add((InstrumentName) item);
            }
            else if (item instanceof String)
            {
                newInstruments.add(new InstrumentName((String) item));
            }
            else
            {
                throw new IllegalArgumentException(
                    item.getClass().getName() + " cannot be converted to an InstrumentName"
                );
            }
        });
        this.queryParams.put("candles", newInstruments);
        return this;
    }

    /**
     * Set the since
     * <p>
     * Date/Time filter to apply to the returned prices. Only prices with a
     * time later than this filter will be provided.
     * <p>
     * @param since the since as a DateTime
     * @return {@link PricingGetRequest PricingGetRequest}
     * @see DateTime
     */
    public PricingGetRequest setSince(DateTime since)
    {
        this.queryParams.put("since", since);
        return this;
    }

    /**
     * Set the since
     * <p>
     * Date/Time filter to apply to the returned prices. Only prices with a
     * time later than this filter will be provided.
     * <p>
     * @param since the since as a String
     * @return {@link PricingGetRequest PricingGetRequest}
     * @see DateTime
     */
    public PricingGetRequest setSince(String since)
    {
        this.queryParams.put("since", new DateTime(since));
        return this;
    }

    /**
     * Set the includeUnitsAvailable
     * <p>
     * Flag that enables the inclusion of the unitsAvailable field in the
     * returned Price objects.
     * <p>
     * @param includeUnitsAvailable the includeUnitsAvailable as a Boolean
     * @return {@link PricingGetRequest PricingGetRequest}
     */
    public PricingGetRequest setIncludeUnitsAvailable(Boolean includeUnitsAvailable)
    {
        this.queryParams.put("includeUnitsAvailable", includeUnitsAvailable);
        return this;
    }
}
