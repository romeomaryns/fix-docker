package eu.maryns.fix.library.model.account;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeSummaryView implements Serializable {

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
    private ClientExtensionsView clientExtensions;
    private String takeProfitOrderID;
    private String stopLossOrderID;
    private String trailingStopLossOrderID;

    public TradeSummaryView() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Instant getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Instant openTime) {
        this.openTime = openTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getInitialUnits() {
        return initialUnits;
    }

    public void setInitialUnits(BigDecimal initialUnits) {
        this.initialUnits = initialUnits;
    }

    public BigDecimal getCurrentUnits() {
        return currentUnits;
    }

    public void setCurrentUnits(BigDecimal currentUnits) {
        this.currentUnits = currentUnits;
    }

    public BigDecimal getRealizedPL() {
        return realizedPL;
    }

    public void setRealizedPL(BigDecimal realizedPL) {
        this.realizedPL = realizedPL;
    }

    public BigDecimal getUnrealizedPL() {
        return unrealizedPL;
    }

    public void setUnrealizedPL(BigDecimal unrealizedPL) {
        this.unrealizedPL = unrealizedPL;
    }

    public BigDecimal getAverageClosePrice() {
        return averageClosePrice;
    }

    public void setAverageClosePrice(BigDecimal averageClosePrice) {
        this.averageClosePrice = averageClosePrice;
    }

    public ArrayList<String> getClosingTransactionIDs() {
        return closingTransactionIDs;
    }

    public void setClosingTransactionIDs(ArrayList<String> closingTransactionIDs) {
        this.closingTransactionIDs = closingTransactionIDs;
    }

    public BigDecimal getFinancing() {
        return financing;
    }

    public void setFinancing(BigDecimal financing) {
        this.financing = financing;
    }

    public Instant getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Instant closeTime) {
        this.closeTime = closeTime;
    }

    public ClientExtensionsView getClientExtensions() {
        return clientExtensions;
    }

    public void setClientExtensions(ClientExtensionsView clientExtensions) {
        this.clientExtensions = clientExtensions;
    }

    public String getTakeProfitOrderID() {
        return takeProfitOrderID;
    }

    public void setTakeProfitOrderID(String takeProfitOrderID) {
        this.takeProfitOrderID = takeProfitOrderID;
    }

    public String getStopLossOrderID() {
        return stopLossOrderID;
    }

    public void setStopLossOrderID(String stopLossOrderID) {
        this.stopLossOrderID = stopLossOrderID;
    }

    public String getTrailingStopLossOrderID() {
        return trailingStopLossOrderID;
    }

    public void setTrailingStopLossOrderID(String trailingStopLossOrderID) {
        this.trailingStopLossOrderID = trailingStopLossOrderID;
    }
}
