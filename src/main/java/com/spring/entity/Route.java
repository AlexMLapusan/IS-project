package com.spring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {

    @Id
    private String id;

    @Column
    private int routeInterval;

    @Column
    private String startingHour;

    @Column
    private String endingHour;

    @OneToOne (mappedBy = "route")
    private Bus bus;

    @ManyToMany(mappedBy = "routes")
    private List<RouteSubscription> rs;

    @ManyToMany(cascade =  CascadeType.ALL)
    @JoinTable(name = "route_station",
            joinColumns = @JoinColumn(name = "id_route"),
            inverseJoinColumns = @JoinColumn(name = "id_station"))
    private List<Station> stations;

    public Route() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRouteInterval() {
        return routeInterval;
    }

    public void setRouteInterval(int interval) {
        this.routeInterval = interval;
    }

    public String getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(String startingHour) {
        this.startingHour = startingHour;
    }

    public String getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(String endingHour) {
        this.endingHour = endingHour;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public List<RouteSubscription> getRs() {
        return rs;
    }

    public void setRs(List<RouteSubscription> rs) {
        this.rs = rs;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
