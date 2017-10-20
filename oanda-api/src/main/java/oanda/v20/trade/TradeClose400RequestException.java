package oanda.v20.trade;

import com.google.gson.annotations.SerializedName;

import oanda.v20.RequestException;
import oanda.v20.transaction.MarketOrderRejectTransaction;

/**
 * TradeClose400RequestException
 */
public class TradeClose400RequestException extends RequestException {

    private static final long serialVersionUID = 6013430296876850573L;

    /**
     * TradeClose400RequestException Constructor
     * <p>
     * Construct a new TradeClose400RequestException
     */
    private TradeClose400RequestException() {
    }

    @SerializedName("orderRejectTransaction") private MarketOrderRejectTransaction orderRejectTransaction;

    /**
     * Get the orderRejectTransaction
     * <p>
     * The MarketOrderReject Transaction that rejects the creation of the
     * Trade-closing MarketOrder.
     * <p>
     * @return the orderRejectTransaction
     * @see MarketOrderRejectTransaction
     */
    public MarketOrderRejectTransaction getOrderRejectTransaction() {
        return this.orderRejectTransaction;
    }
}
