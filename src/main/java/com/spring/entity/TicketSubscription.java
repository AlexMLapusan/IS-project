package com.spring.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket_subscription")
public class TicketSubscription {

    @Id
    private String id;

    @Column
    private Date creationDate;

    @Column
    private Date expiryDate;

}
