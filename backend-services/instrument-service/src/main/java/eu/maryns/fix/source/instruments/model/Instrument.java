package eu.maryns.fix.source.instruments.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Instrument implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

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
    private InstrumentCommission commission;


    protected Instrument() {
        this.id = null;
        this.type=null;
        this.displayName=null;
        this.pipLocation=null;
        this.displayPrecision=null;
        this.tradeUnitsPrecision=null;
        this.minimumTradeSize=null;
        this.maximumTrailingStopDistance=null;
        this.minimumTrailingStopDistance=null;
        this.maximumPositionSize=null;
        this.maximumOrderUnits=null;
        this.marginRate=null;
        this.commission=null;
    }

    public Instrument(com.oanda.v20.primitives.Instrument other) {
        this.name = other.getName().toString();
        this.type = InstrumentType.valueOf(other.getType().name());
        this.displayName = other.getDisplayName();
        if (other.getPipLocation() != null)
        {
            this.pipLocation = new Integer(other.getPipLocation());
        }
        if (other.getDisplayPrecision() != null)
        {
            this.displayPrecision = new Integer(other.getDisplayPrecision());
        }
        if (other.getTradeUnitsPrecision() != null)
        {
            this.tradeUnitsPrecision = new Integer(other.getTradeUnitsPrecision());
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
}
