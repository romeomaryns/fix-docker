package eu.maryns.fix.source.instruments.contract;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oanda.v20.primitives.InstrumentCommission;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstrumentCommissionView {

    private Long id;
    private String instrument;
    private BigDecimal commission;
    private BigDecimal unitsTraded;
    private BigDecimal minimumCommission;

    public InstrumentCommissionView(InstrumentCommission commission) {
        try {
            this.instrument = commission.getInstrument().toString();
            this.commission = commission.getCommission().bigDecimalValue();
            this.unitsTraded = commission.getUnitsTraded().bigDecimalValue();
            this.minimumCommission = commission.getMinimumCommission().bigDecimalValue();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
