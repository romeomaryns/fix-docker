package eu.maryns.fix.source.instruments;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Candle implements Serializable{

    @Id
    @Generated
    private String id;

    private String instrument;
    private String time;
    private String status;
    private Boolean tradeable;
    private String quoteHomeConversionFactors;
    private String unitsAvailable;

    protected Candle() {

        this.id = null;

        this.instrument=null;
        this.time=null;
        this.status=null;
        this.tradeable=null;
        this.quoteHomeConversionFactors=null;
        this.unitsAvailable=null;
    }

}
