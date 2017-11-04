package eu.maryns.fix.source.instruments.model;

import org.neo4j.ogm.annotation.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@NodeEntity
public class Instrument implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Index(unique = true)
    private String name;
    @NotNull
    @Index
    private String type;
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
    @Relationship(type = "COMMISSION")
    private InstrumentCommission commission;


    protected Instrument() {
    }

    public Instrument(com.oanda.v20.primitives.Instrument other) {
        this.name = other.getName().toString();
        this.type = other.getType().name();
        this.displayName = other.getDisplayName();
        if (other.getPipLocation() != null)
        {
            this.pipLocation = other.getPipLocation();
        }
        if (other.getDisplayPrecision() != null)
        {
            this.displayPrecision = other.getDisplayPrecision();
        }
        if (other.getTradeUnitsPrecision() != null)
        {
            this.tradeUnitsPrecision = other.getTradeUnitsPrecision();
        }
        this.minimumTradeSize = other.getMinimumTradeSize().bigDecimalValue();
        this.maximumTrailingStopDistance = other.getMaximumTrailingStopDistance().bigDecimalValue();
        this.minimumTrailingStopDistance = other.getMinimumTrailingStopDistance().bigDecimalValue();
        this.maximumPositionSize = other.getMaximumPositionSize().bigDecimalValue();
        this.maximumOrderUnits = other.getMaximumOrderUnits().bigDecimalValue();
        this.marginRate = other.getMarginRate().bigDecimalValue();
        if (other.getCommission() != null)
        {
            this.commission = new InstrumentCommission(other.getCommission());
        }
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public InstrumentCommission getCommission() {
        return commission;
    }

    public void setCommission(InstrumentCommission commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        String sb = "Instrument{" + "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", displayName='" + displayName + '\'' +
                ", pipLocation=" + pipLocation +
                ", displayPrecision=" + displayPrecision +
                ", tradeUnitsPrecision=" + tradeUnitsPrecision +
                ", minimumTradeSize=" + minimumTradeSize +
                ", maximumTrailingStopDistance=" + maximumTrailingStopDistance +
                ", minimumTrailingStopDistance=" + minimumTrailingStopDistance +
                ", maximumPositionSize=" + maximumPositionSize +
                ", maximumOrderUnits=" + maximumOrderUnits +
                ", marginRate=" + marginRate +
                ", commission=" + commission.toString() +
                '}';
        return sb;
    }
}
