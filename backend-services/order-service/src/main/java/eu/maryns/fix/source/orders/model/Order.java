package eu.maryns.fix.source.orders.model;

//import eu.maryns.fix.account.model.ClientExtensions;
import lombok.Data;

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
    private String orderState;
  //  private ClientExtensions clientExtensions;


}
