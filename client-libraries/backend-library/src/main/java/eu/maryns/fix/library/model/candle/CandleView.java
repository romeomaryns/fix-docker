package eu.maryns.fix.library.model.candle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CandleView implements Serializable{

    private Long id;
    private Instant time;
    private CandlestickDataView bid;
    private CandlestickDataView ask;
    private CandlestickDataView mid;
    private Integer volume;
    private Boolean complete;
    private String instrument;
    private String granularity;


    protected CandleView() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public CandlestickDataView getBid() {
        return bid;
    }

    public void setBid(CandlestickDataView bid) {
        this.bid = bid;
    }

    public CandlestickDataView getAsk() {
        return ask;
    }

    public void setAsk(CandlestickDataView ask) {
        this.ask = ask;
    }

    public CandlestickDataView getMid() {
        return mid;
    }

    public void setMid(CandlestickDataView mid) {
        this.mid = mid;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }
}
