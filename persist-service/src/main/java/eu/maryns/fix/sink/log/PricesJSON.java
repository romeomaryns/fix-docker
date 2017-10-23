package eu.maryns.fix.sink.log;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PricesJSON {
    @JsonProperty(value = "")
    private List<PriceJSON> pricesList;

    public PricesJSON(){}
}
