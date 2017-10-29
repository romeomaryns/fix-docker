package eu.maryns.fix.library.model.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountView implements Serializable{


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
    private ArrayList<TradeSummaryView> trades;
    /*@OneToMany
    private ArrayList<PositionView> positions;
    @OneToMany
    private ArrayList<OrderView> orders;*/

    public AccountView(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getCreatedByUserID() {
        return createdByUserID;
    }

    public void setCreatedByUserID(Integer createdByUserID) {
        this.createdByUserID = createdByUserID;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public BigDecimal getPl() {
        return pl;
    }

    public void setPl(BigDecimal pl) {
        this.pl = pl;
    }

    public BigDecimal getResettablePL() {
        return resettablePL;
    }

    public void setResettablePL(BigDecimal resettablePL) {
        this.resettablePL = resettablePL;
    }

    public Instant getResettabledPLTime() {
        return resettabledPLTime;
    }

    public void setResettabledPLTime(Instant resettabledPLTime) {
        this.resettabledPLTime = resettabledPLTime;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(BigDecimal marginRate) {
        this.marginRate = marginRate;
    }

    public Instant getMarginCallEnterTime() {
        return marginCallEnterTime;
    }

    public void setMarginCallEnterTime(Instant marginCallEnterTime) {
        this.marginCallEnterTime = marginCallEnterTime;
    }

    public Integer getMarginCallExtensionCount() {
        return marginCallExtensionCount;
    }

    public void setMarginCallExtensionCount(Integer marginCallExtensionCount) {
        this.marginCallExtensionCount = marginCallExtensionCount;
    }

    public Instant getLastMarginCallExtensionTime() {
        return lastMarginCallExtensionTime;
    }

    public void setLastMarginCallExtensionTime(Instant lastMarginCallExtensionTime) {
        this.lastMarginCallExtensionTime = lastMarginCallExtensionTime;
    }

    public Integer getOpenTradeCount() {
        return openTradeCount;
    }

    public void setOpenTradeCount(Integer openTradeCount) {
        this.openTradeCount = openTradeCount;
    }

    public Integer getOpenPositionCount() {
        return openPositionCount;
    }

    public void setOpenPositionCount(Integer openPositionCount) {
        this.openPositionCount = openPositionCount;
    }

    public Integer getPendingOrderCount() {
        return pendingOrderCount;
    }

    public void setPendingOrderCount(Integer pendingOrderCount) {
        this.pendingOrderCount = pendingOrderCount;
    }

    public Boolean getHedgingEnabled() {
        return hedgingEnabled;
    }

    public void setHedgingEnabled(Boolean hedgingEnabled) {
        this.hedgingEnabled = hedgingEnabled;
    }

    public BigDecimal getUnrealizedPL() {
        return unrealizedPL;
    }

    public void setUnrealizedPL(BigDecimal unrealizedPL) {
        this.unrealizedPL = unrealizedPL;
    }

    public BigDecimal getnAV() {
        return nAV;
    }

    public void setnAV(BigDecimal nAV) {
        this.nAV = nAV;
    }

    public BigDecimal getMarginUsed() {
        return marginUsed;
    }

    public void setMarginUsed(BigDecimal marginUsed) {
        this.marginUsed = marginUsed;
    }

    public BigDecimal getMarginAvailable() {
        return marginAvailable;
    }

    public void setMarginAvailable(BigDecimal marginAvailable) {
        this.marginAvailable = marginAvailable;
    }

    public BigDecimal getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(BigDecimal positionValue) {
        this.positionValue = positionValue;
    }

    public BigDecimal getMarginCloseoutUnrealizedPL() {
        return marginCloseoutUnrealizedPL;
    }

    public void setMarginCloseoutUnrealizedPL(BigDecimal marginCloseoutUnrealizedPL) {
        this.marginCloseoutUnrealizedPL = marginCloseoutUnrealizedPL;
    }

    public BigDecimal getMarginCloseoutNAV() {
        return marginCloseoutNAV;
    }

    public void setMarginCloseoutNAV(BigDecimal marginCloseoutNAV) {
        this.marginCloseoutNAV = marginCloseoutNAV;
    }

    public BigDecimal getMarginCloseoutMarginUsed() {
        return marginCloseoutMarginUsed;
    }

    public void setMarginCloseoutMarginUsed(BigDecimal marginCloseoutMarginUsed) {
        this.marginCloseoutMarginUsed = marginCloseoutMarginUsed;
    }

    public BigDecimal getMarginCloseoutPercent() {
        return marginCloseoutPercent;
    }

    public void setMarginCloseoutPercent(BigDecimal marginCloseoutPercent) {
        this.marginCloseoutPercent = marginCloseoutPercent;
    }

    public BigDecimal getMarginCloseoutPositionValue() {
        return marginCloseoutPositionValue;
    }

    public void setMarginCloseoutPositionValue(BigDecimal marginCloseoutPositionValue) {
        this.marginCloseoutPositionValue = marginCloseoutPositionValue;
    }

    public BigDecimal getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(BigDecimal withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public BigDecimal getMarginCallMarginUsed() {
        return marginCallMarginUsed;
    }

    public void setMarginCallMarginUsed(BigDecimal marginCallMarginUsed) {
        this.marginCallMarginUsed = marginCallMarginUsed;
    }

    public BigDecimal getMarginCallPercent() {
        return marginCallPercent;
    }

    public void setMarginCallPercent(BigDecimal marginCallPercent) {
        this.marginCallPercent = marginCallPercent;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

    public ArrayList<TradeSummaryView> getTrades() {
        return trades;
    }

    public void setTrades(ArrayList<TradeSummaryView> trades) {
        this.trades = trades;
    }
}
