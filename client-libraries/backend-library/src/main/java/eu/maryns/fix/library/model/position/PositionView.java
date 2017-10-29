package eu.maryns.fix.library.model.position;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionView implements Serializable {

    private String instrument;
    private BigDecimal pl;
    private BigDecimal unrealizedPL;
    private BigDecimal resettablePL;
    private BigDecimal commission;
    @SerializedName("long") private PositionSideView longValue;
    @SerializedName("short") private PositionSideView shortValue;

    public PositionView() {
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public BigDecimal getPl() {
        return pl;
    }

    public void setPl(BigDecimal pl) {
        this.pl = pl;
    }

    public BigDecimal getUnrealizedPL() {
        return unrealizedPL;
    }

    public void setUnrealizedPL(BigDecimal unrealizedPL) {
        this.unrealizedPL = unrealizedPL;
    }

    public BigDecimal getResettablePL() {
        return resettablePL;
    }

    public void setResettablePL(BigDecimal resettablePL) {
        this.resettablePL = resettablePL;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public PositionSideView getLongValue() {
        return longValue;
    }

    public void setLongValue(PositionSideView longValue) {
        this.longValue = longValue;
    }

    public PositionSideView getShortValue() {
        return shortValue;
    }

    public void setShortValue(PositionSideView shortValue) {
        this.shortValue = shortValue;
    }
}
