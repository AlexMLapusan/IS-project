package com.spring.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "_transaction")
public class Transaction {

    @Id
    private String id;

    public enum Type {
        _1_ROUTE_SUBSCRIPTION,
        _2_ROUTES_SUBSCRIPTION,
        _30_TRIPS_SUBSCRIPTION,
        _60_TRIPS_SUBSCRIPTION,
        _90_TRIPS_SUBSCRIPTION,
        _120_TRIPS_SUBSCRIPTION,
        UNLIMITED_TRIPS_SUBSCRIPTION,
        TICKET
    }

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Column
    private float income;

    @Column
    private Date purchaseDate;

    @Column
    private String itemId;

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
