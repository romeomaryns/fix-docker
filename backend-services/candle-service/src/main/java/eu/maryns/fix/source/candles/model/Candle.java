package eu.maryns.fix.source.candles.model;

import com.oanda.v20.instrument.Candlestick;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.ParseException;
import java.time.Instant;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"time" })})
public class Candle implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Instant time;
    @OneToOne(cascade = CascadeType.ALL)
    private CandlestickData bid;
    @OneToOne(cascade = CascadeType.ALL)
    private CandlestickData ask;
    @OneToOne(cascade = CascadeType.ALL)
    private CandlestickData mid;
    private Integer volume;
    private Boolean complete;
    @NotNull
    private String instrument;
    @NotNull
    private String granularity;


    protected Candle() {
        this.bid=null;
        this.ask=null;
        this.mid=null;
        this.volume=null;
        this.complete=null;
        this.time=null;
    }

    public Candle(Candlestick other, String instrument,CandleStickGranularity granularity) throws ParseException {
        this.time = Instant.parse(other.getTime().toString());
        if (other.getBid() != null)
        {
            this.bid = new CandlestickData(other.getBid());
        }
        if (other.getAsk() != null)
        {
            this.ask = new CandlestickData(other.getAsk());
        }
        if (other.getMid() != null)
        {
            this.mid = new CandlestickData(other.getMid());
        }
        if (other.getVolume() != null)
        {
            this.volume = new Integer(other.getVolume());
        }
        if (other.getComplete() != null)
        {
            this.complete = new Boolean(other.getComplete());
        }
        if(null != instrument){
            this.instrument = instrument;
        }
        if(null != granularity){
            this.granularity = granularity.name();
        }
    }
}
