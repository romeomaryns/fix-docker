package eu.maryns.fix.library.model.price;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceView implements Serializable{

    private String id;
    private String type;
    private String instrument;
    private String time;
    private String status;
    private Boolean tradeable;
    private ArrayList<BidView> bids = new ArrayList<BidView>();
    private ArrayList<AskView> asks = new ArrayList<AskView>();
  //  private Bid closeoutBid;
  //  private Ask closeoutAsk;
    private String quoteHomeConversionFactors;
    private String unitsAvailable;

    public PriceView() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getTradeable() {
        return tradeable;
    }

    public void setTradeable(Boolean tradeable) {
        this.tradeable = tradeable;
    }

    public ArrayList<BidView> getBids() {
        return bids;
    }

    public void setBids(ArrayList<BidView> bids) {
        this.bids = bids;
    }

    public ArrayList<AskView> getAsks() {
        return asks;
    }

    public void setAsks(ArrayList<AskView> asks) {
        this.asks = asks;
    }

    public String getQuoteHomeConversionFactors() {
        return quoteHomeConversionFactors;
    }

    public void setQuoteHomeConversionFactors(String quoteHomeConversionFactors) {
        this.quoteHomeConversionFactors = quoteHomeConversionFactors;
    }

    public String getUnitsAvailable() {
        return unitsAvailable;
    }

    public void setUnitsAvailable(String unitsAvailable) {
        this.unitsAvailable = unitsAvailable;
    }
}
