package oanda.v20.trade;

import com.google.gson.annotations.SerializedName;

import oanda.v20.Request;
import oanda.v20.account.AccountID;
import oanda.v20.transaction.StopLossDetails;
import oanda.v20.transaction.TakeProfitDetails;
import oanda.v20.transaction.TrailingStopLossDetails;

/**
 * TradeSetDependentOrdersRequest
 */
public class TradeSetDependentOrdersRequest extends Request {

    private static class Body {
        @SerializedName("takeProfit") private TakeProfitDetails takeProfit;
        @SerializedName("stopLoss") private StopLossDetails stopLoss;
        @SerializedName("trailingStopLoss") private TrailingStopLossDetails trailingStopLoss;
    }

    /**
     * TradeSetDependentOrdersRequest Constructor
     * <p>
     * Construct a new TradeSetDependentOrdersRequest
     * <p>
     * @param accountID Account Identifier
     * @param tradeSpecifier Specifier for the Trade
     */
    public TradeSetDependentOrdersRequest(AccountID accountID, TradeSpecifier tradeSpecifier) {
        this.body = new Body();
        this.setPathParam("accountID", accountID);
        this.setPathParam("tradeSpecifier", tradeSpecifier);

    }

    /**
     * Set the takeProfit
     * <p>
     * The specification of the Take Profit to create/modify/cancel. If
     * takeProfit is set to null, the Take Profit Order will be cancelled if it
     * exists. If takeProfit is not provided, the exisiting Take Profit Order
     * will not be modified. If a sub-field of takeProfit is not specified,
     * that field will be set to a default value on create, and be inherited by
     * the replacing order on modify.
     * <p>
     * @param takeProfit the takeProfit as a TakeProfitDetails
     * @return {@link TradeSetDependentOrdersRequest
     * TradeSetDependentOrdersRequest}
     * @see TakeProfitDetails
     */
    public TradeSetDependentOrdersRequest setTakeProfit(TakeProfitDetails takeProfit)
    {
        ((Body) this.body).takeProfit = takeProfit;
        return this;
    }

    /**
     * Set the stopLoss
     * <p>
     * The specification of the Stop Loss to create/modify/cancel. If stopLoss
     * is set to null, the Stop Loss Order will be cancelled if it exists. If
     * stopLoss is not provided, the exisiting Stop Loss Order will not be
     * modified. If a sub-field of stopLoss is not specified, that field will
     * be set to a default value on create, and be inherited by the replacing
     * order on modify.
     * <p>
     * @param stopLoss the stopLoss as a StopLossDetails
     * @return {@link TradeSetDependentOrdersRequest
     * TradeSetDependentOrdersRequest}
     * @see StopLossDetails
     */
    public TradeSetDependentOrdersRequest setStopLoss(StopLossDetails stopLoss)
    {
        ((Body) this.body).stopLoss = stopLoss;
        return this;
    }

    /**
     * Set the trailingStopLoss
     * <p>
     * The specification of the Trailing Stop Loss to create/modify/cancel. If
     * trailingStopLoss is set to null, the Trailing Stop Loss Order will be
     * cancelled if it exists. If trailingStopLoss is not provided, the
     * exisiting Trailing Stop Loss Order will not be modified. If a sub-field
     * of trailngStopLoss is not specified, that field will be set to a default
     * value on create, and be inherited by the replacing order on modify.
     * <p>
     * @param trailingStopLoss the trailingStopLoss as a
     * TrailingStopLossDetails
     * @return {@link TradeSetDependentOrdersRequest
     * TradeSetDependentOrdersRequest}
     * @see TrailingStopLossDetails
     */
    public TradeSetDependentOrdersRequest setTrailingStopLoss(TrailingStopLossDetails trailingStopLoss)
    {
        ((Body) this.body).trailingStopLoss = trailingStopLoss;
        return this;
    }
}
