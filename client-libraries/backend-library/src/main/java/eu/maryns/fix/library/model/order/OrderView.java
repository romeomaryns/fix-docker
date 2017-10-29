package eu.maryns.fix.library.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.maryns.fix.library.model.account.ClientExtensionsView;

import java.io.Serializable;
import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderView implements Serializable {


    private String id;
    private String type;
    private Instant createTime;
    private String orderState;
    private ClientExtensionsView clientExtensions;

    public OrderView(){

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public ClientExtensionsView getClientExtensions() {
        return clientExtensions;
    }

    public void setClientExtensions(ClientExtensionsView clientExtensions) {
        this.clientExtensions = clientExtensions;
    }
}
