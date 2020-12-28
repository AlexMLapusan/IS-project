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

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
