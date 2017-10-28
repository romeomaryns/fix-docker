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




    public ClientExtensions() {
    }



    public ClientExtensions(com.oanda.v20.transaction.ClientExtensions other) {
        this.id = other.getId();
        this.tag = other.getTag();
        this.comment = other.getComment();
    }

    @SerializedName("tag") private ClientTag tag;

    /**
     * Get the Tag
     * <p>
     * A tag associated with the Order/Trade
     * <p>
     * @return the Tag
     * @see ClientTag
     */
    public ClientTag getTag() {
        return this.tag;
    }

    /**
     * Set the Tag
     * <p>
     * A tag associated with the Order/Trade
     * <p>
     * @param tag the Tag as a ClientTag
     * @return {@link ClientExtensions ClientExtensions}
     * @see ClientTag
     */
    public ClientExtensions setTag(ClientTag tag) {
        this.tag = tag;
        return this;
    }
    /**
     * Set the Tag
     * <p>
     * A tag associated with the Order/Trade
     * <p>
     * @param tag the Tag as a String
     * @return {@link ClientExtensions ClientExtensions}
     * @see ClientTag
     */
    public ClientExtensions setTag(String tag) {
        this.tag = new ClientTag(tag);
        return this;
    }

    @SerializedName("comment") private ClientComment comment;

    /**
     * Get the Comment
     * <p>
     * A comment associated with the Order/Trade
     * <p>
     * @return the Comment
     * @see ClientComment
     */
    public ClientComment getComment() {
        return this.comment;
    }

    /**
     * Set the Comment
     * <p>
     * A comment associated with the Order/Trade
     * <p>
     * @param comment the Comment as a ClientComment
     * @return {@link ClientExtensions ClientExtensions}
     * @see ClientComment
     */
    public ClientExtensions setComment(ClientComment comment) {
        this.comment = comment;
        return this;
    }
    /**
     * Set the Comment
     * <p>
     * A comment associated with the Order/Trade
     * <p>
     * @param comment the Comment as a String
     * @return {@link ClientExtensions ClientExtensions}
     * @see ClientComment
     */
    public ClientExtensions setComment(String comment) {
        this.comment = new ClientComment(comment);
        return this;
    }
}
