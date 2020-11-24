package entity;

import javax.persistence.*;

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
}
