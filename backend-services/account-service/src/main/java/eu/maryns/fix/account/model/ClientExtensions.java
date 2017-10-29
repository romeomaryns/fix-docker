package eu.maryns.fix.account.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"id" })})
public class ClientExtensions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientExtensionsId;

    private String id;
    private String tag;
    private String comment;

    public ClientExtensions(com.oanda.v20.transaction.ClientExtensions other) {
        this.id = other.getId().toString();
        this.tag = other.getTag().toString();
        this.comment = other.getComment().toString();
    }

}
