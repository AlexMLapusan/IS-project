package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "_transaction")
public class Transaction {

    @Id
    private String id;

    private enum Type {
        TICKET,
        ROUTE_SUBSCRIPTION,
        TICKET_SUBSCRIPTION
    } ;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Column
    private float income;

    @Column
    private Date purchaseDate;
}
