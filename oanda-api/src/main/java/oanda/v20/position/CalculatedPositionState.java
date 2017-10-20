package oanda.v20.position;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

import oanda.v20.primitives.AccountUnits;
import oanda.v20.primitives.InstrumentName;

/**
 * The dynamic (calculated) state of a Position
 */
public class CalculatedPositionState {

    /**
     * Default constructor.
     */
    public CalculatedPositionState() {
    }

    /**
     * Copy constructor
     * <p>
     * @param other the CalculatedPositionState to copy
     */
    public CalculatedPositionState(CalculatedPositionState other) {
        this.instrument = other.instrument;
        this.netUnrealizedPL = other.netUnrealizedPL;
        this.longUnrealizedPL = other.longUnrealizedPL;
        this.shortUnrealizedPL = other.shortUnrealizedPL;
    }

    @SerializedName("instrument") private InstrumentName instrument;

    /**
     * Get the Instrument
     * <p>
     * The Position's Instrument.
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
     * The Position's Instrument.
     * <p>
     * @param instrument the Instrument as an InstrumentName
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see InstrumentName
     */
    public CalculatedPositionState setInstrument(InstrumentName instrument) {
        this.instrument = instrument;
        return this;
    }
    /**
     * Set the Instrument
     * <p>
     * The Position's Instrument.
     * <p>
     * @param instrument the Instrument as a String
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see InstrumentName
     */
    public CalculatedPositionState setInstrument(String instrument) {
        this.instrument = new InstrumentName(instrument);
        return this;
    }

    @SerializedName("netUnrealizedPL") private AccountUnits netUnrealizedPL;

    /**
     * Get the Net Unrealized Profit/Loss
     * <p>
     * The Position's net unrealized profit/loss
     * <p>
     * @return the Net Unrealized Profit/Loss
     * @see AccountUnits
     */
    public AccountUnits getNetUnrealizedPL() {
        return this.netUnrealizedPL;
    }

    /**
     * Set the Net Unrealized Profit/Loss
     * <p>
     * The Position's net unrealized profit/loss
     * <p>
     * @param netUnrealizedPL the Net Unrealized Profit/Loss as an AccountUnits
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setNetUnrealizedPL(AccountUnits netUnrealizedPL) {
        this.netUnrealizedPL = netUnrealizedPL;
        return this;
    }
    /**
     * Set the Net Unrealized Profit/Loss
     * <p>
     * The Position's net unrealized profit/loss
     * <p>
     * @param netUnrealizedPL the Net Unrealized Profit/Loss as a String
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setNetUnrealizedPL(String netUnrealizedPL) {
        this.netUnrealizedPL = new AccountUnits(netUnrealizedPL);
        return this;
    }
    /**
     * Set the Net Unrealized Profit/Loss
     * <p>
     * The Position's net unrealized profit/loss
     * <p>
     * @param netUnrealizedPL the Net Unrealized Profit/Loss as a double
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setNetUnrealizedPL(double netUnrealizedPL) {
        this.netUnrealizedPL = new AccountUnits(netUnrealizedPL);
        return this;
    }
    /**
     * Set the Net Unrealized Profit/Loss
     * <p>
     * The Position's net unrealized profit/loss
     * <p>
     * @param netUnrealizedPL the Net Unrealized Profit/Loss as a BigDecimal
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setNetUnrealizedPL(BigDecimal netUnrealizedPL) {
        this.netUnrealizedPL = new AccountUnits(netUnrealizedPL);
        return this;
    }

    @SerializedName("longUnrealizedPL") private AccountUnits longUnrealizedPL;

    /**
     * Get the Long Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's long open Trades
     * <p>
     * @return the Long Unrealized Profit/Loss
     * @see AccountUnits
     */
    public AccountUnits getLongUnrealizedPL() {
        return this.longUnrealizedPL;
    }

    /**
     * Set the Long Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's long open Trades
     * <p>
     * @param longUnrealizedPL the Long Unrealized Profit/Loss as an
     * AccountUnits
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setLongUnrealizedPL(AccountUnits longUnrealizedPL) {
        this.longUnrealizedPL = longUnrealizedPL;
        return this;
    }
    /**
     * Set the Long Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's long open Trades
     * <p>
     * @param longUnrealizedPL the Long Unrealized Profit/Loss as a String
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setLongUnrealizedPL(String longUnrealizedPL) {
        this.longUnrealizedPL = new AccountUnits(longUnrealizedPL);
        return this;
    }
    /**
     * Set the Long Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's long open Trades
     * <p>
     * @param longUnrealizedPL the Long Unrealized Profit/Loss as a double
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setLongUnrealizedPL(double longUnrealizedPL) {
        this.longUnrealizedPL = new AccountUnits(longUnrealizedPL);
        return this;
    }
    /**
     * Set the Long Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's long open Trades
     * <p>
     * @param longUnrealizedPL the Long Unrealized Profit/Loss as a BigDecimal
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setLongUnrealizedPL(BigDecimal longUnrealizedPL) {
        this.longUnrealizedPL = new AccountUnits(longUnrealizedPL);
        return this;
    }

    @SerializedName("shortUnrealizedPL") private AccountUnits shortUnrealizedPL;

    /**
     * Get the Short Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's short open Trades
     * <p>
     * @return the Short Unrealized Profit/Loss
     * @see AccountUnits
     */
    public AccountUnits getShortUnrealizedPL() {
        return this.shortUnrealizedPL;
    }

    /**
     * Set the Short Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's short open Trades
     * <p>
     * @param shortUnrealizedPL the Short Unrealized Profit/Loss as an
     * AccountUnits
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setShortUnrealizedPL(AccountUnits shortUnrealizedPL) {
        this.shortUnrealizedPL = shortUnrealizedPL;
        return this;
    }
    /**
     * Set the Short Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's short open Trades
     * <p>
     * @param shortUnrealizedPL the Short Unrealized Profit/Loss as a String
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setShortUnrealizedPL(String shortUnrealizedPL) {
        this.shortUnrealizedPL = new AccountUnits(shortUnrealizedPL);
        return this;
    }
    /**
     * Set the Short Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's short open Trades
     * <p>
     * @param shortUnrealizedPL the Short Unrealized Profit/Loss as a double
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setShortUnrealizedPL(double shortUnrealizedPL) {
        this.shortUnrealizedPL = new AccountUnits(shortUnrealizedPL);
        return this;
    }
    /**
     * Set the Short Unrealized Profit/Loss
     * <p>
     * The unrealized profit/loss of the Position's short open Trades
     * <p>
     * @param shortUnrealizedPL the Short Unrealized Profit/Loss as a
     * BigDecimal
     * @return {@link CalculatedPositionState CalculatedPositionState}
     * @see AccountUnits
     */
    public CalculatedPositionState setShortUnrealizedPL(BigDecimal shortUnrealizedPL) {
        this.shortUnrealizedPL = new AccountUnits(shortUnrealizedPL);
        return this;
    }
}
