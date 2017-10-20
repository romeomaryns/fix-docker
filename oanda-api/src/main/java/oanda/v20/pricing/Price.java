package oanda.v20.pricing;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

import oanda.v20.order.UnitsAvailable;
import oanda.v20.primitives.DateTime;
import oanda.v20.primitives.InstrumentName;

/**
 * The specification of an Account-specific Price.
 */
public class Price {

    /**
     * Default constructor.
     */
    public Price() {
    }

    /**
     * Copy constructor
     * <p>
     * @param other the Price to copy
     */
    public Price(Price other) {
        this.type = other.type;
        this.instrument = other.instrument;
        this.time = other.time;
        this.status = other.status;
        if (other.tradeable != null)
        {
            this.tradeable = new Boolean(other.tradeable);
        }
        if (other.bids != null)
        {
            this.bids = new ArrayList<PriceBucket>(other.bids);
        }
        if (other.asks != null)
        {
            this.asks = new ArrayList<PriceBucket>(other.asks);
        }
        this.closeoutBid = other.closeoutBid;
        this.closeoutAsk = other.closeoutAsk;
        if (other.quoteHomeConversionFactors != null)
        {
            this.quoteHomeConversionFactors = new QuoteHomeConversionFactors(other.quoteHomeConversionFactors);
        }
        if (other.unitsAvailable != null)
        {
            this.unitsAvailable = new UnitsAvailable(other.unitsAvailable);
        }
    }

    @SerializedName("type") private String type = "PRICE";

    /**
     * Get the Type
     * <p>
     * The string "PRICE". Used to identify the a Price object when found in a
     * stream.
     * <p>
     * @return the Type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Set the Type
     * <p>
     * The string "PRICE". Used to identify the a Price object when found in a
     * stream.
     * <p>
     * @param type the Type as a String
     * @return {@link Price Price}
     */
    public Price setType(String type) {
        this.type = type;
        return this;
    }

    @SerializedName("instrument") private InstrumentName instrument;

    /**
     * Get the Instrument
     * <p>
     * The Price's Instrument.
     * <p>
     * @return the Instrument
     * @see InstrumentName
     */
    public InstrumentName getInstrument() {
        return this.instrument;
    }

    /**
     * Set the Instrument
     * <p>
     * The Price's Instrument.
     * <p>
     * @param instrument the Instrument as an InstrumentName
     * @return {@link Price Price}
     * @see InstrumentName
     */
    public Price setInstrument(InstrumentName instrument) {
        this.instrument = instrument;
        return this;
    }
    /**
     * Set the Instrument
     * <p>
     * The Price's Instrument.
     * <p>
     * @param instrument the Instrument as a String
     * @return {@link Price Price}
     * @see InstrumentName
     */
    public Price setInstrument(String instrument) {
        this.instrument = new InstrumentName(instrument);
        return this;
    }

    @SerializedName("time") private DateTime time;

    /**
     * Get the Time
     * <p>
     * The date/time when the Price was created
     * <p>
     * @return the Time
     * @see DateTime
     */
    public DateTime getTime() {
        return this.time;
    }

    /**
     * Set the Time
     * <p>
     * The date/time when the Price was created
     * <p>
     * @param time the Time as a DateTime
     * @return {@link Price Price}
     * @see DateTime
     */
    public Price setTime(DateTime time) {
        this.time = time;
        return this;
    }
    /**
     * Set the Time
     * <p>
     * The date/time when the Price was created
     * <p>
     * @param time the Time as a String
     * @return {@link Price Price}
     * @see DateTime
     */
    public Price setTime(String time) {
        this.time = new DateTime(time);
        return this;
    }

    @SerializedName("status") private PriceStatus status;

    /**
     * Get the Status
     * <p>
     * The status of the Price.
     * <p>
     * @return the Status
     * @see PriceStatus
     */
    public PriceStatus getStatus() {
        return this.status;
    }

    /**
     * Set the Status
     * <p>
     * The status of the Price.
     * <p>
     * @param status the Status as a PriceStatus
     * @return {@link Price Price}
     * @see PriceStatus
     */
    public Price setStatus(PriceStatus status) {
        this.status = status;
        return this;
    }

    @SerializedName("tradeable") private Boolean tradeable;

    /**
     * Get the Is Tradeable
     * <p>
     * Flag indicating if the Price is tradeable or not
     * <p>
     * @return the Is Tradeable
     */
    public Boolean getTradeable() {
        return this.tradeable;
    }

    /**
     * Set the Is Tradeable
     * <p>
     * Flag indicating if the Price is tradeable or not
     * <p>
     * @param tradeable the Is Tradeable as a Boolean
     * @return {@link Price Price}
     */
    public Price setTradeable(Boolean tradeable) {
        this.tradeable = tradeable;
        return this;
    }

    @SerializedName("bids") private ArrayList<PriceBucket> bids;

    /**
     * Get the Bids
     * <p>
     * The list of prices and liquidity available on the Instrument's bid side.
     * It is possible for this list to be empty if there is no bid liquidity
     * currently available for the Instrument in the Account.
     * <p>
     * @return the Bids
     * @see PriceBucket
     */
    public List<PriceBucket> getBids() {
        return this.bids;
    }

    /**
     * Set the Bids
     * <p>
     * The list of prices and liquidity available on the Instrument's bid side.
     * It is possible for this list to be empty if there is no bid liquidity
     * currently available for the Instrument in the Account.
     * <p>
     * @param bids the Bids
     * @return {@link Price Price}
     * @see PriceBucket
     */
    public Price setBids(Collection<?> bids) {
        ArrayList<PriceBucket> newBids = new ArrayList<PriceBucket>(bids.size());
        bids.forEach((item) -> {
            if (item instanceof PriceBucket)
            {
                newBids.add((PriceBucket) item);
            }
            else
            {
                throw new IllegalArgumentException(
                    item.getClass().getName() + " cannot be converted to a PriceBucket"
                );
            }
        });
        this.bids = newBids;
        return this;
    }

    @SerializedName("asks") private ArrayList<PriceBucket> asks;

    /**
     * Get the Asks
     * <p>
     * The list of prices and liquidity available on the Instrument's ask side.
     * It is possible for this list to be empty if there is no ask liquidity
     * currently available for the Instrument in the Account.
     * <p>
     * @return the Asks
     * @see PriceBucket
     */
    public List<PriceBucket> getAsks() {
        return this.asks;
    }

    /**
     * Set the Asks
     * <p>
     * The list of prices and liquidity available on the Instrument's ask side.
     * It is possible for this list to be empty if there is no ask liquidity
     * currently available for the Instrument in the Account.
     * <p>
     * @param asks the Asks
     * @return {@link Price Price}
     * @see PriceBucket
     */
    public Price setAsks(Collection<?> asks) {
        ArrayList<PriceBucket> newAsks = new ArrayList<PriceBucket>(asks.size());
        asks.forEach((item) -> {
            if (item instanceof PriceBucket)
            {
                newAsks.add((PriceBucket) item);
            }
            else
            {
                throw new IllegalArgumentException(
                    item.getClass().getName() + " cannot be converted to a PriceBucket"
                );
            }
        });
        this.asks = newAsks;
        return this;
    }

    @SerializedName("closeoutBid") private PriceValue closeoutBid;

    /**
     * Get the Closeout Bid
     * <p>
     * The closeout bid Price. This Price is used when a bid is required to
     * closeout a Position (margin closeout or manual) yet there is no bid
     * liquidity. The closeout bid is never used to open a new position.
     * <p>
     * @return the Closeout Bid
     * @see PriceValue
     */
    public PriceValue getCloseoutBid() {
        return this.closeoutBid;
    }

    /**
     * Set the Closeout Bid
     * <p>
     * The closeout bid Price. This Price is used when a bid is required to
     * closeout a Position (margin closeout or manual) yet there is no bid
     * liquidity. The closeout bid is never used to open a new position.
     * <p>
     * @param closeoutBid the Closeout Bid as a PriceValue
     * @return {@link Price Price}
     * @see PriceValue
     */
    public Price setCloseoutBid(PriceValue closeoutBid) {
        this.closeoutBid = closeoutBid;
        return this;
    }
    /**
     * Set the Closeout Bid
     * <p>
     * The closeout bid Price. This Price is used when a bid is required to
     * closeout a Position (margin closeout or manual) yet there is no bid
     * liquidity. The closeout bid is never used to open a new position.
     * <p>
     * @param closeoutBid the Closeout Bid as a String
     * @return {@link Price Price}
     * @see PriceValue
     */
    public Price setCloseoutBid(String closeoutBid) {
        this.closeoutBid = new PriceValue(closeoutBid);
        return this;
    }
    /**
     * Set the Closeout Bid
     * <p>
     * The closeout bid Price. This Price is used when a bid is required to
     * closeout a Position (margin closeout or manual) yet there is no bid
     * liquidity. The closeout bid is never used to open a new position.
     * <p>
     * @param closeoutBid the Closeout Bid as a double
     * @return {@link Price Price}
     * @see PriceValue
     */
    public Price setCloseoutBid(double closeoutBid) {
        this.closeoutBid = new PriceValue(closeoutBid);
        return this;
    }
    /**
     * Set the Closeout Bid
     * <p>
     * The closeout bid Price. This Price is used when a bid is required to
     * closeout a Position (margin closeout or manual) yet there is no bid
     * liquidity. The closeout bid is never used to open a new position.
     * <p>
     * @param closeoutBid the Closeout Bid as a BigDecimal
     * @return {@link Price Price}
     * @see PriceValue
     */
    public Price setCloseoutBid(BigDecimal closeoutBid) {
        this.closeoutBid = new PriceValue(closeoutBid);
        return this;
    }

    @SerializedName("closeoutAsk") private PriceValue closeoutAsk;

    /**
     * Get the Closeout Ask
     * <p>
     * The closeout ask Price. This Price is used when a ask is required to
     * closeout a Position (margin closeout or manual) yet there is no ask
     * liquidity. The closeout ask is never used to open a new position.
     * <p>
     * @return the Closeout Ask
     * @see PriceValue
     */
    public PriceValue getCloseoutAsk() {
        return this.closeoutAsk;
    }

    /**
     * Set the Closeout Ask
     * <p>
     * The closeout ask Price. This Price is used when a ask is required to
     * closeout a Position (margin closeout or manual) yet there is no ask
     * liquidity. The closeout ask is never used to open a new position.
     * <p>
     * @param closeoutAsk the Closeout Ask as a PriceValue
     * @return {@link Price Price}
     * @see PriceValue
     */
    public Price setCloseoutAsk(PriceValue closeoutAsk) {
        this.closeoutAsk = closeoutAsk;
        return this;
    }
    /**
     * Set the Closeout Ask
     * <p>
     * The closeout ask Price. This Price is used when a ask is required to
     * closeout a Position (margin closeout or manual) yet there is no ask
     * liquidity. The closeout ask is never used to open a new position.
     * <p>
     * @param closeoutAsk the Closeout Ask as a String
     * @return {@link Price Price}
     * @see PriceValue
     */
    public Price setCloseoutAsk(String closeoutAsk) {
        this.closeoutAsk = new PriceValue(closeoutAsk);
        return this;
    }
    /**
     * Set the Closeout Ask
     * <p>
     * The closeout ask Price. This Price is used when a ask is required to
     * closeout a Position (margin closeout or manual) yet there is no ask
     * liquidity. The closeout ask is never used to open a new position.
     * <p>
     * @param closeoutAsk the Closeout Ask as a double
     * @return {@link Price Price}
     * @see PriceValue
     */
    public Price setCloseoutAsk(double closeoutAsk) {
        this.closeoutAsk = new PriceValue(closeoutAsk);
        return this;
    }
    /**
     * Set the Closeout Ask
     * <p>
     * The closeout ask Price. This Price is used when a ask is required to
     * closeout a Position (margin closeout or manual) yet there is no ask
     * liquidity. The closeout ask is never used to open a new position.
     * <p>
     * @param closeoutAsk the Closeout Ask as a BigDecimal
     * @return {@link Price Price}
     * @see PriceValue
     */
    public Price setCloseoutAsk(BigDecimal closeoutAsk) {
        this.closeoutAsk = new PriceValue(closeoutAsk);
        return this;
    }

    @SerializedName("quoteHomeConversionFactors") private QuoteHomeConversionFactors quoteHomeConversionFactors;

    /**
     * Get the Quote Home Conversions
     * <p>
     * The factors used to convert quantities of this price's Instrument's
     * quote currency into a quantity of the Account's home currency.
     * <p>
     * @return the Quote Home Conversions
     * @see QuoteHomeConversionFactors
     */
    public QuoteHomeConversionFactors getQuoteHomeConversionFactors() {
        return this.quoteHomeConversionFactors;
    }

    /**
     * Set the Quote Home Conversions
     * <p>
     * The factors used to convert quantities of this price's Instrument's
     * quote currency into a quantity of the Account's home currency.
     * <p>
     * @param quoteHomeConversionFactors the Quote Home Conversions as a
     * QuoteHomeConversionFactors
     * @return {@link Price Price}
     * @see QuoteHomeConversionFactors
     */
    public Price setQuoteHomeConversionFactors(QuoteHomeConversionFactors quoteHomeConversionFactors) {
        this.quoteHomeConversionFactors = quoteHomeConversionFactors;
        return this;
    }

    @SerializedName("unitsAvailable") private UnitsAvailable unitsAvailable;

    /**
     * Get the Units Available
     * <p>
     * Representation of how many units of an Instrument are available to be
     * traded by an Order depending on its postionFill option.
     * <p>
     * @return the Units Available
     * @see UnitsAvailable
     */
    public UnitsAvailable getUnitsAvailable() {
        return this.unitsAvailable;
    }

    /**
     * Set the Units Available
     * <p>
     * Representation of how many units of an Instrument are available to be
     * traded by an Order depending on its postionFill option.
     * <p>
     * @param unitsAvailable the Units Available as an UnitsAvailable
     * @return {@link Price Price}
     * @see UnitsAvailable
     */
    public Price setUnitsAvailable(UnitsAvailable unitsAvailable) {
        this.unitsAvailable = unitsAvailable;
        return this;
    }
}
