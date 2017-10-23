package eu.maryns.fix.source.instruments.model;

import com.google.gson.annotations.SerializedName;
import com.oanda.v20.pricing.PriceBucket;
import com.oanda.v20.primitives.DecimalNumber;
import com.oanda.v20.primitives.InstrumentCommission;
import com.oanda.v20.primitives.InstrumentName;
import com.oanda.v20.primitives.InstrumentType;
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

    private String name;
    private String type;
    private String displayName;
    private Float pipLocation;
    private Float displayPrecision;
    private Float tradeUnitsPrecision;
    private BigDecimal minimumTradeSize;
    private BigDecimal maximumTrailingStopDistance;
    private BigDecimal minimumTrailingStopDistance;
    private BigDecimal maximumPositionSize;
    private BigDecimal maximumOrderUnits;
    private BigDecimal marginRate;
    private BigDecimal commission;


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

    public Instrument(com.oanda.v20.primitives.Instrument instrument) {
        this.id = instrument.getDisplayName()+instrument.getType().name()+instrument.getTradeUnitsPrecision();
        this.type=((instrument.getType() == null) ? "N/A" : instrument.getType().name());
        this.displayName=((instrument.getDisplayName() == null) ? "N/A" : instrument.getDisplayName());
        this.pipLocation=((instrument.getPipLocation() == null) ? new Float(0) : instrument.getPipLocation().floatValue());
        this.displayPrecision=((instrument.getDisplayPrecision() == null) ? new Float(0) : instrument.getDisplayPrecision().floatValue());
        this.tradeUnitsPrecision=((instrument.getTradeUnitsPrecision() == null) ? new Float(0) : instrument.getTradeUnitsPrecision().floatValue());
        this.minimumTradeSize=((instrument.getMinimumTradeSize() == null) ? new BigDecimal(0) : instrument.getMinimumTradeSize().bigDecimalValue());
        this.maximumTrailingStopDistance=((instrument.getMaximumTrailingStopDistance() == null) ? new BigDecimal(0) : instrument.getMaximumTrailingStopDistance().bigDecimalValue());
        this.minimumTrailingStopDistance=((instrument.getMinimumTrailingStopDistance() == null) ? new BigDecimal(0) : instrument.getMinimumTrailingStopDistance().bigDecimalValue());
        this.maximumPositionSize=((instrument.getMaximumPositionSize() == null) ? new BigDecimal(0) : instrument.getMaximumPositionSize().bigDecimalValue());
        this.maximumOrderUnits=((instrument.getMaximumOrderUnits() == null) ? new BigDecimal(0) : instrument.getMaximumOrderUnits().bigDecimalValue());
        this.marginRate=((instrument.getMarginRate() == null) ? new BigDecimal(0) : instrument.getMarginRate().bigDecimalValue());
        this.commission=((instrument.getCommission() == null) ? new BigDecimal(0) : instrument.getCommission().getCommission().bigDecimalValue());
    }
}
