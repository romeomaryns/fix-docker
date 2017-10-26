package eu.maryns.fix.source.prices;

import com.oanda.v20.pricing.PriceValue;
import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Bid implements Serializable{

    @Id
    @Generated
    private String id;
    private final BigDecimal price;
    private final Integer liquidity;

    public Bid(BigDecimal price, Integer liquidity) {
        this.price = price;
        this.liquidity=liquidity;
        this.id=null;
    }

    public Bid(BigDecimal closeoutBid) {
        this.price=closeoutBid;
        this.liquidity=null;
        this.id=null;
    }
}
