package eu.maryns.fix.library.model.position;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionSideView {

    private Long id;
    private BigDecimal units;
    private BigDecimal averagePrice;
    private ArrayList<String> tradeIDs;
    private BigDecimal pl;
    private BigDecimal unrealizedPL;
    private BigDecimal resettablePL;

    public PositionSideView() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getUnits() {
        return units;
    }

    public void setUnits(BigDecimal units) {
        this.units = units;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public ArrayList<String> getTradeIDs() {
        return tradeIDs;
    }

    public void setTradeIDs(ArrayList<String> tradeIDs) {
        this.tradeIDs = tradeIDs;
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
}
