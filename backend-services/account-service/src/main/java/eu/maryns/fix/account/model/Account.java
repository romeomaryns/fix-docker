package eu.maryns.fix.account.model;

import eu.maryns.fix.source.orders.model.Order;
import eu.maryns.fix.source.positions.model.Position;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"id" })})
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String id;

    private String alias;
    private String currency;
    private BigDecimal balance;
    private Integer createdByUserID;
    private Instant createdTime;
    private BigDecimal pl;
    private BigDecimal resettablePL;
    private Instant resettabledPLTime;
    private BigDecimal commission;
    private BigDecimal marginRate;
    private Instant marginCallEnterTime;
    private Integer marginCallExtensionCount;
    private Instant lastMarginCallExtensionTime;
    private Integer openTradeCount;
    private Integer openPositionCount;
    private Integer pendingOrderCount;
    private Boolean hedgingEnabled;
    private BigDecimal unrealizedPL;
    private BigDecimal nAV;
    private BigDecimal marginUsed;
    private BigDecimal marginAvailable;
    private BigDecimal positionValue;
    private BigDecimal marginCloseoutUnrealizedPL;
    private BigDecimal marginCloseoutNAV;
    private BigDecimal marginCloseoutMarginUsed;
    private BigDecimal marginCloseoutPercent;
    private BigDecimal marginCloseoutPositionValue;
    private BigDecimal withdrawalLimit;
    private BigDecimal marginCallMarginUsed;
    private BigDecimal marginCallPercent;
    private String lastTransactionID;
    @OneToMany
    private ArrayList<TradeSummary> trades;
    @OneToMany
    private ArrayList<Position> positions;
    @OneToMany
    private ArrayList<Order> orders;


    protected Account() {

    }


    public Account(com.oanda.v20.account.Account other) {
        this.id = other.getId().toString();
        this.alias = other.getAlias();
        this.currency = other.getCurrency().toString();
        this.balance = other.getBalance().bigDecimalValue();
        if (other.getCreatedByUserID() != null)
        {
            this.createdByUserID = new Integer(other.getCreatedByUserID());
        }
        this.createdTime = Instant.parse(other.getCreatedTime());
        this.pl = other.getPl().bigDecimalValue();
        this.resettablePL = other.getResettablePL().bigDecimalValue();
        this.resettabledPLTime = Instant.parse(other.getResettabledPLTime());
        this.commission = other.getCommission().bigDecimalValue();
        this.marginRate = other.getMarginRate().bigDecimalValue();
        this.marginCallEnterTime = Instant.parse(other.getMarginCallEnterTime());
        if (other.getMarginCallExtensionCount() != null)
        {
            this.marginCallExtensionCount = new Integer(other.getMarginCallExtensionCount());
        }
        this.lastMarginCallExtensionTime = Instant.parse(other.getLastMarginCallExtensionTime());
        if (other.getOpenTradeCount() != null)
        {
            this.openTradeCount = new Integer(other.getOpenTradeCount());
        }
        if (other.getOpenPositionCount() != null)
        {
            this.openPositionCount = new Integer(other.getOpenPositionCount());
        }
        if (other.getPendingOrderCount() != null)
        {
            this.pendingOrderCount = new Integer(other.getPendingOrderCount());
        }
        if (other.getHedgingEnabled() != null)
        {
            this.hedgingEnabled = new Boolean(other.getHedgingEnabled());
        }
        this.unrealizedPL = other.getUnrealizedPL().bigDecimalValue();
        this.nAV = other.getNAV().bigDecimalValue();
        this.marginUsed = other.getMarginUsed().bigDecimalValue();
        this.marginAvailable = other.getMarginAvailable().bigDecimalValue();
        this.positionValue = other.getPositionValue().bigDecimalValue();
        this.marginCloseoutUnrealizedPL = other.getMarginCloseoutUnrealizedPL().bigDecimalValue();
        this.marginCloseoutNAV = other.getMarginCloseoutNAV().bigDecimalValue();
        this.marginCloseoutMarginUsed = other.getMarginCloseoutMarginUsed().bigDecimalValue();
        this.marginCloseoutPercent = other.getMarginCloseoutPercent().bigDecimalValue();
        this.marginCloseoutPositionValue = other.getMarginCloseoutPositionValue().bigDecimalValue();
        this.withdrawalLimit = other.getWithdrawalLimit().bigDecimalValue();
        this.marginCallMarginUsed = other.getMarginCallMarginUsed().bigDecimalValue();
        this.marginCallPercent = other.getMarginCallPercent().bigDecimalValue();
        this.lastTransactionID = other.getLastTransactionID().toString();
        if (other.getTrades() != null)
        {
            this.trades = new ArrayList<TradeSummary>();
            for (com.oanda.v20.trade.TradeSummary summary: other.getTrades()) {
                this.trades.add(new TradeSummary(summary));
            }
        }
        if (other.getPositions() != null)
        {
            this.positions = new ArrayList<Position>();
            for (com.oanda.v20.position.Position position: other.getPositions()) {
                this.positions.add(new Position(position));
            }
        }
        if (other.getOrders() != null)
        {
            this.orders = new ArrayList<Order>();
            for (com.oanda.v20.order.Order order: other.getOrders()) {
               // this.orders.add(new Order(order));
            }
        }
    }

}
