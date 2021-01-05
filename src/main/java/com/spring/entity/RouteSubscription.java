package com.spring.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "route_subscription")
public class RouteSubscription {

    @Id
    private String id;

    public enum Type {
        _1_ROUTE_SUBSCRIPTION,
        _2_ROUTES_SUBSCRIPTION,
    };

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Column
    private Date createDate;

    @Column
    private Date expiryDate;

    @ManyToMany(cascade =  CascadeType.MERGE)
    @JoinTable(name = "rs_routes",
            joinColumns = @JoinColumn(name = "id_subscription"),
            inverseJoinColumns = @JoinColumn(name = "id_route"))
    private List<Route> routes;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public RouteSubscription() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
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
