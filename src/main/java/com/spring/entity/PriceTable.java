package com.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "price_table")
public class PriceTable {
    //TODO: Add all the necessary class variables, getters and setters
    @Id
    private String id;

    public enum Type {
        _1_ROUTE_SUBSCRIPTION,
        _2_ROUTES_SUBSCRIPTION,
        _30_TRIPS_SUBSCRIPTION,
        _60_TRIPS_SUBSCRIPTION,
        _90_TRIPS_SUBSCRIPTION,
        _120_TRIPS_SUBSCRIPTION,
        _UNLIMITED_TRIPS_SUBSCRIPTION,
        TICKET
    }

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Column
    private float price;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
