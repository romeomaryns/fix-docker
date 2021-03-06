package oanda.v20.account;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import oanda.v20.primitives.Instrument;
import oanda.v20.transaction.TransactionID;

/**
 * AccountInstrumentsResponse
 */
public class AccountInstrumentsResponse {

    /**
     * AccountInstrumentsResponse Constructor
     * <p>
     * Construct a new AccountInstrumentsResponse
     */
    private AccountInstrumentsResponse() {
    }

    @SerializedName("candles") private ArrayList<Instrument> instruments;

    /**
     * Get the candles
     * <p>
     * The requested list of candles.
     * <p>
     * @return the candles
     * @see Instrument
     */
    public List<Instrument> getInstruments() {
        return this.instruments;
    }

    @SerializedName("lastTransactionID") private TransactionID lastTransactionID;

    /**
     * Get the lastTransactionID
     * <p>
     * The ID of the most recent Transaction created for the Account.
     * <p>
     * @return the lastTransactionID
     * @see TransactionID
     */
    public TransactionID getLastTransactionID() {
        return this.lastTransactionID;
    }
}
