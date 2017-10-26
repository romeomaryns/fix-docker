package eu.maryns.fix.source.prices;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Ask implements Serializable{
    @Id
    @Generated
    private String id;
    private final BigDecimal price;
    private final Integer liquidity;

    public Ask(BigDecimal price, Integer liquidity) {
        this.price = price;
        this.liquidity=liquidity;
        this.id=null;
    }


    public Ask(BigDecimal closeoutAsk) {
        this.price=closeoutAsk;
        this.liquidity=null;
        this.id=null;
    }
}
