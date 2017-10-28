package eu.maryns.fix.account.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;

import java.math.BigDecimal;

import com.oanda.v20.transaction.TransactionID;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"id" })})
public class TradeSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tradeSummaryId;

    public TradeSummary() {
    }

    public TradeSummary(com.oanda.v20.trade.TradeSummary other) {
        this.id = other.getId().toString();
        this.instrument = other.getInstrument().toString();
        this.price = other.getPrice().bigDecimalValue();
        this.openTime = Instant.parse(other.getOpenTime());
        this.state = other.getState().toString();
        this.initialUnits = other.getInitialUnits().bigDecimalValue();
        this.currentUnits = other.getCurrentUnits().bigDecimalValue();
        this.realizedPL = other.getRealizedPL().bigDecimalValue();
        this.unrealizedPL = other.getUnrealizedPL().bigDecimalValue();
        this.averageClosePrice = other.getAverageClosePrice().bigDecimalValue();
        if (other.getClosingTransactionIDs() != null)
        {
            this.closingTransactionIDs = new ArrayList<String>();
            for(TransactionID transactionID : other.getClosingTransactionIDs()){
                this.closingTransactionIDs.add(transactionID.toString());
            }
        }
        this.financing = other.getFinancing().bigDecimalValue();
        this.closeTime = Instant.parse(other.getCloseTime());
        this.clientExtensions = new ClientExtensions(other.getClientExtensions());
        this.takeProfitOrderID = other.getTakeProfitOrderID().toString();
        this.stopLossOrderID = other.getStopLossOrderID().toString();
        this.trailingStopLossOrderID = other.getTrailingStopLossOrderID().toString();
    }

    private String id;
    private String instrument;
    private BigDecimal price;
    private Instant openTime;
    private String state;
    private BigDecimal initialUnits;
    private BigDecimal currentUnits;
    private BigDecimal realizedPL;
    private BigDecimal unrealizedPL;
    private BigDecimal averageClosePrice;
    private ArrayList<String> closingTransactionIDs;
    private BigDecimal financing;
    private Instant closeTime;
    private ClientExtensions clientExtensions;
    private String takeProfitOrderID;
    private String stopLossOrderID;
    private String trailingStopLossOrderID;
}
