package eu.maryns.fix.library.model.price;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AskView implements Serializable{


    private String id;
    private BigDecimal price;
    private Integer liquidity;

    public AskView() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getLiquidity() {
        return liquidity;
    }
}
