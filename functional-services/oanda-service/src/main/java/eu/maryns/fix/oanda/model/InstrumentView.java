package eu.maryns.fix.oanda.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oanda.v20.primitives.Instrument;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstrumentView implements Serializable{


    private Long id;
    private String name;
    private InstrumentType type;
    private String displayName;
    private Integer pipLocation;
    private Integer displayPrecision;
    private Integer tradeUnitsPrecision;
    private BigDecimal minimumTradeSize;
    private BigDecimal maximumTrailingStopDistance;
    private BigDecimal minimumTrailingStopDistance;
    private BigDecimal maximumPositionSize;
    private BigDecimal maximumOrderUnits;
    private BigDecimal marginRate;
    private InstrumentCommissionView commission;


    public InstrumentView() {

    }

    public InstrumentView(Instrument instrument) {
        this.name = instrument.getName().toString();
        this.type = InstrumentType.valueOf(instrument.getType().name());
        this.displayName = instrument.getDisplayName();
        this.pipLocation = instrument.getPipLocation();
        this.displayPrecision = instrument.getDisplayPrecision();
        this.tradeUnitsPrecision = instrument.getTradeUnitsPrecision();
        this.minimumTradeSize = instrument.getMinimumTradeSize().bigDecimalValue();
        this.maximumTrailingStopDistance = instrument.getMaximumTrailingStopDistance().bigDecimalValue();
        this.minimumTrailingStopDistance = instrument.getMaximumTrailingStopDistance().bigDecimalValue();
        this.maximumPositionSize = instrument.getMaximumPositionSize().bigDecimalValue();
        this.maximumOrderUnits = instrument.getMaximumOrderUnits().bigDecimalValue();
        this.marginRate = instrument.getMarginRate().bigDecimalValue();
        this.commission = new InstrumentCommissionView(instrument.getCommission());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstrumentType getType() {
        return type;
    }

    public void setType(InstrumentType type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getPipLocation() {
        return pipLocation;
    }

    public void setPipLocation(Integer pipLocation) {
        this.pipLocation = pipLocation;
    }

    public Integer getDisplayPrecision() {
        return displayPrecision;
    }

    public void setDisplayPrecision(Integer displayPrecision) {
        this.displayPrecision = displayPrecision;
    }

    public Integer getTradeUnitsPrecision() {
        return tradeUnitsPrecision;
    }

    public void setTradeUnitsPrecision(Integer tradeUnitsPrecision) {
        this.tradeUnitsPrecision = tradeUnitsPrecision;
    }

    public BigDecimal getMinimumTradeSize() {
        return minimumTradeSize;
    }

    public void setMinimumTradeSize(BigDecimal minimumTradeSize) {
        this.minimumTradeSize = minimumTradeSize;
    }

    public BigDecimal getMaximumTrailingStopDistance() {
        return maximumTrailingStopDistance;
    }

    public void setMaximumTrailingStopDistance(BigDecimal maximumTrailingStopDistance) {
        this.maximumTrailingStopDistance = maximumTrailingStopDistance;
    }

    public BigDecimal getMinimumTrailingStopDistance() {
        return minimumTrailingStopDistance;
    }

    public void setMinimumTrailingStopDistance(BigDecimal minimumTrailingStopDistance) {
        this.minimumTrailingStopDistance = minimumTrailingStopDistance;
    }

    public BigDecimal getMaximumPositionSize() {
        return maximumPositionSize;
    }

    public void setMaximumPositionSize(BigDecimal maximumPositionSize) {
        this.maximumPositionSize = maximumPositionSize;
    }

    public BigDecimal getMaximumOrderUnits() {
        return maximumOrderUnits;
    }

    public void setMaximumOrderUnits(BigDecimal maximumOrderUnits) {
        this.maximumOrderUnits = maximumOrderUnits;
    }

    public BigDecimal getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(BigDecimal marginRate) {
        this.marginRate = marginRate;
    }

    public InstrumentCommissionView getCommission() {
        return commission;
    }

    public void setCommission(InstrumentCommissionView commission) {
        this.commission = commission;
    }
}
