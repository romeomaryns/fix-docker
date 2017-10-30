package eu.maryns.fix.source.instruments.model;


import eu.maryns.fix.source.instruments.contract.InstrumentCommissionView;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class InstrumentCommission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String instrument;
    private BigDecimal commission;
    private BigDecimal unitsTraded;
    private BigDecimal minimumCommission;

    public InstrumentCommission(com.oanda.v20.primitives.InstrumentCommission other) {
        this.instrument = other.getInstrument().toString();
        this.commission = other.getCommission().bigDecimalValue();
        this.unitsTraded = other.getUnitsTraded().bigDecimalValue();
        this.minimumCommission = other.getMinimumCommission().bigDecimalValue();
    }

    public InstrumentCommission(InstrumentCommissionView commission) {
        this.instrument = commission.getInstrument().toString();
        this.commission = commission.getCommission();
        this.unitsTraded = commission.getUnitsTraded();
        this.minimumCommission = commission.getMinimumCommission();
    }

}
