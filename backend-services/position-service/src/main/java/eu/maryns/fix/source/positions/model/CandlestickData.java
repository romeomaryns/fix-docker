package eu.maryns.fix.source.candles.model;

import java.math.BigDecimal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class CandlestickData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal o;
    private BigDecimal h;
    private BigDecimal l;
    private BigDecimal c;

    public CandlestickData(){
        this.o = null;
        this.h = null;
        this.l = null;
        this.c = null;
    }

    public CandlestickData(com.oanda.v20.instrument.CandlestickData other) {
        this.o = other.getO().bigDecimalValue();
        this.h = other.getH().bigDecimalValue();
        this.l = other.getL().bigDecimalValue();
        this.c = other.getC().bigDecimalValue();
    }


}
