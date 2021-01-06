package com.spring.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trips_subscription")
public class TripsSubscription {

    @Id
    private String id;

    public enum Type {
        _30_TRIPS_SUBSCRIPTION,
        _60_TRIPS_SUBSCRIPTION,
        _90_TRIPS_SUBSCRIPTION,
        _120_TRIPS_SUBSCRIPTION,
        UNLIMITED_TRIPS_SUBSCRIPTION,
    };

    @Enumerated(EnumType.ORDINAL)
    private Type type;

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


    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
