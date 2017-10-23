package eu.maryns.fix.source.instruments;

import com.oanda.v20.pricing.PriceBucket;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@Entity
public class Instrument implements Serializable{

    @Id
    @Generated
    private String id;

    private String type;
    private String instrument;
    private String time;
    private String status;
    private Boolean tradeable;
    private String quoteHomeConversionFactors;
    private String unitsAvailable;

    public Instrument(String type,
                      String instrument,
                      String time,
                      String status,
                      boolean tradeable,
                      String quoteHomeConversionFactors,
                      String unitsAvailable) {

        this.type=type;
        this.instrument=instrument;
        this.time=time;
        this.status=status;
        this.tradeable=tradeable;
        this.quoteHomeConversionFactors=quoteHomeConversionFactors;
        this.unitsAvailable=unitsAvailable;
        this.id = null;
    }

    protected Instrument() {

        this.id = null;
        this.type=null;
        this.instrument=null;
        this.time=null;
        this.status=null;
        this.tradeable=null;
        this.quoteHomeConversionFactors=null;
        this.unitsAvailable=null;
    }

    public Instrument(com.oanda.v20.pricing.Price price) {
        this.id=price.getInstrument().toString()+price.getTime().toString()+price.getType();
        this.type=price.getType();
        this.instrument=((price.getInstrument() == null) ? "N/A" : price.getInstrument().toString());
        this.time=((price.getTime() == null) ? "N/A" : price.getTime().toString());
        this.status=((price.getStatus() == null) ? "N/A" :price.getStatus().name());
        this.tradeable=((price.getTradeable()== null) ? false : price.getTradeable());
        this.quoteHomeConversionFactors=((price.getQuoteHomeConversionFactors() == null) ? "N/A" : price.getQuoteHomeConversionFactors().toString());
        this.unitsAvailable=((price.getUnitsAvailable() == null) ? "N/A" : price.getUnitsAvailable().toString());
    }
}
