package eu.maryns.fix.source.prices.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Ask implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
