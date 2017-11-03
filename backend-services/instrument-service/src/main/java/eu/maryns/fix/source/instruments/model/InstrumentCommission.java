package eu.maryns.fix.source.instruments.model;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.math.BigDecimal;

@NodeEntity
public class InstrumentCommission {

    @Id
    @GeneratedValue
    private Long id;

    private String instrument;
    private BigDecimal commission;
    private BigDecimal unitsTraded;
    private BigDecimal minimumCommission;

    public InstrumentCommission(){}

    public InstrumentCommission(com.oanda.v20.primitives.InstrumentCommission other) {
        this.instrument = other.getInstrument().toString();
        this.commission = other.getCommission().bigDecimalValue();
        this.unitsTraded = other.getUnitsTraded().bigDecimalValue();
        this.minimumCommission = other.getMinimumCommission().bigDecimalValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getUnitsTraded() {
        return unitsTraded;
    }

    public void setUnitsTraded(BigDecimal unitsTraded) {
        this.unitsTraded = unitsTraded;
    }

    public BigDecimal getMinimumCommission() {
        return minimumCommission;
    }

    public void setMinimumCommission(BigDecimal minimumCommission) {
        this.minimumCommission = minimumCommission;
    }
}
