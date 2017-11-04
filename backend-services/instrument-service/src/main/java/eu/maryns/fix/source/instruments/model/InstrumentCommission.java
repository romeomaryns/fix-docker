package eu.maryns.fix.source.instruments.model;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

import java.math.BigDecimal;

@NodeEntity
public class InstrumentCommission {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique = true)
    private String instrument;
    private BigDecimal commission;
    private BigDecimal unitsTraded;
    private BigDecimal minimumCommission;

    public InstrumentCommission(){}

    public InstrumentCommission(com.oanda.v20.primitives.InstrumentCommission other) {
      if(null != other)
      {
          this.instrument = ((null == other.getInstrument()) ? "N/A" : other.getInstrument().toString());
          this.commission = ((null == other.getCommission()) ? new BigDecimal(0) : other.getCommission().bigDecimalValue());
          this.unitsTraded = ((null == other.getUnitsTraded()) ? new BigDecimal(0) : other.getUnitsTraded().bigDecimalValue());
          this.minimumCommission = ((null == other.getMinimumCommission()) ? new BigDecimal(0) : other.getMinimumCommission().bigDecimalValue());
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

    @Override
    public String toString() {
        return "InstrumentCommission{" +
                "id=" + id +
                ", instrument='" + instrument + '\'' +
                ", commission=" + commission +
                ", unitsTraded=" + unitsTraded +
                ", minimumCommission=" + minimumCommission +
                '}';
    }
}
