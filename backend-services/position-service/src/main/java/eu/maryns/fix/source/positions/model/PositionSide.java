package eu.maryns.fix.source.positions.model;

import java.util.ArrayList;
import java.math.BigDecimal;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"id" })})
public class PositionSide {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal units;
    private BigDecimal averagePrice;
    private ArrayList<String> tradeIDs;
    private BigDecimal pl;
    private BigDecimal unrealizedPL;
    private BigDecimal resettablePL;

    public PositionSide() {
    }

    public PositionSide(com.oanda.v20.position.PositionSide other) {
        this.units = other.getUnits().bigDecimalValue();
        this.averagePrice = other.getAveragePrice().bigDecimalValue();
        if (other.getTradeIDs() != null)
        {
            this.tradeIDs = new ArrayList<String>();
            other.getTradeIDs().stream().forEach(tradeID -> this.tradeIDs.add(tradeID.toString()));
        }
        this.pl = other.getPl().bigDecimalValue();
        this.unrealizedPL = other.getUnrealizedPL().bigDecimalValue();
        this.resettablePL = other.getResettablePL().bigDecimalValue();
    }


}
