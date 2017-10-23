package eu.maryns.fix.source.prices;

import com.oanda.v20.pricing.PriceBucket;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@Entity
public class Price implements Serializable{

    @Id
    @Generated
    private String id;

    private String type;
    private String instrument;
    private String time;
    private String status;
    private Boolean tradeable;
    private ArrayList<Bid> bids = new ArrayList<Bid>();
    private ArrayList<Ask> asks = new ArrayList<Ask>();
  //  private Bid closeoutBid;
  //  private Ask closeoutAsk;
    private String quoteHomeConversionFactors;
    private String unitsAvailable;

    public Price(String type,
                 String instrument,
                 String time,
                 String status,
                 boolean tradeable,
                 ArrayList<Bid> bids,
                 ArrayList<Ask> asks,
                 Bid closeoutBid,
                 Ask closeoutAsk,
                 String quoteHomeConversionFactors,
                 String unitsAvailable) {

        this.type=type;
        this.instrument=instrument;
        this.time=time;
        this.status=status;
        this.tradeable=tradeable;
        this.bids=bids;
        this.asks=asks;
   //     this.closeoutBid=closeoutBid;
   //     this.closeoutAsk=closeoutAsk;
        this.quoteHomeConversionFactors=quoteHomeConversionFactors;
        this.unitsAvailable=unitsAvailable;
        this.id = null;
    }

    protected Price() {

        this.id = null;
        this.type=null;
        this.instrument=null;
        this.time=null;
        this.status=null;
        this.tradeable=null;
        this.bids=null;
        this.asks=null;
    //    this.closeoutBid=null;
    //    this.closeoutAsk=null;
        this.quoteHomeConversionFactors=null;
        this.unitsAvailable=null;
    }

    public Price(com.oanda.v20.pricing.Price price) {
        this.id=price.getInstrument().toString()+price.getTime().toString()+price.getType();
        this.type=price.getType();
        this.instrument=((price.getInstrument() == null) ? "N/A" : price.getInstrument().toString());
        this.time=((price.getTime() == null) ? "N/A" : price.getTime().toString());
        this.status=((price.getStatus() == null) ? "N/A" :price.getStatus().name());
        this.tradeable=((price.getTradeable()== null) ? false : price.getTradeable());
        if(null != price.getBids()) {
            price.getBids().stream()
                    .forEach((priceBucket) ->
                            bids.add(new Bid(
                                    ((priceBucket.getPrice() == null) ? new BigDecimal(0) : priceBucket.getPrice().bigDecimalValue())
                                    , ((priceBucket.getLiquidity() == null) ? 0 : priceBucket.getLiquidity())))
                    );
        }
        if(null != price.getAsks()) {
            price.getAsks().stream()
                    .forEach(priceBucket ->
                            asks.add(new Ask(
                                    ((priceBucket.getPrice() == null) ? new BigDecimal(0) : priceBucket.getPrice().bigDecimalValue())
                                    , ((priceBucket.getLiquidity() == null) ? 0 : priceBucket.getLiquidity())))
                    );
        }
     //   this.closeoutBid= new Bid(price.getCloseoutBid().bigDecimalValue());
      //  this.closeoutAsk= new Ask(price.getCloseoutAsk().bigDecimalValue());
        this.quoteHomeConversionFactors=((price.getQuoteHomeConversionFactors() == null) ? "N/A" : price.getQuoteHomeConversionFactors().toString());
        this.unitsAvailable=((price.getUnitsAvailable() == null) ? "N/A" : price.getUnitsAvailable().toString());
    }
}
