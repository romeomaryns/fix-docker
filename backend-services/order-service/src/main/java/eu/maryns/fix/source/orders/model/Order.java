package eu.maryns.fix.source.orders.model;

import com.oanda.v20.order.OrderID;
import com.oanda.v20.order.OrderState;
import com.oanda.v20.order.OrderType;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.transaction.ClientExtensions;
import lombok.Data;
import oanda.v20.primitives.DateTime;
import oanda.v20.transaction.ClientExtensions;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"id" })})
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private String id;
    private String type;
    private Instant createTime;

    @Override
    public OrderState getState() {
        return null;
    }

    @Override
    public com.oanda.v20.order.Order setState(OrderState orderState) {
        return null;
    }

    @Override
    public ClientExtensions getClientExtensions() {
        return null;
    }

    @Override
    public com.oanda.v20.order.Order setClientExtensions(ClientExtensions clientExtensions) {
        return null;
    }
}
