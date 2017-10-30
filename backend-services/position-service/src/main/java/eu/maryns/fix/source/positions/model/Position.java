package eu.maryns.fix.source.positions.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;


@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"positionId" })})
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long positionId;

    private String instrument;
    private BigDecimal pl;
    private BigDecimal unrealizedPL;
    private BigDecimal resettablePL;
    private BigDecimal commission;
    @OneToOne(cascade = CascadeType.ALL)
    @SerializedName("long") private PositionSide longValue;
    @OneToOne(cascade = CascadeType.ALL)
    @SerializedName("short") private PositionSide shortValue;

    public Position() {
    }

    public Position(com.oanda.v20.position.Position other) {
        this.instrument = other.getInstrument().toString();
        this.pl = other.getPl().bigDecimalValue();
        this.unrealizedPL = other.getUnrealizedPL().bigDecimalValue();
        this.resettablePL = other.getResettablePL().bigDecimalValue();
        this.commission = other.getCommission().bigDecimalValue();
        if (other.getLong() != null)
        {
            this.longValue = new PositionSide(other.getLong());
        }
        if (other.getShort() != null)
        {
            this.shortValue = new PositionSide(other.getShort());
        }
    }


}
