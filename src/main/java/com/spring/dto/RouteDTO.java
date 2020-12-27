package com.spring.dto;

public class RouteDTO {
    private String alias;
    private String startingHour;
    private String endingHour;
    private int routeInterval;
    private RouteDTO(String alias,String startingHour,String endingHour,int routeInterval)
    {
        this.alias=alias;
        this.startingHour=startingHour;
        this.endingHour=endingHour;
        this.routeInterval=routeInterval;
    }

    public String getAlias() { return alias; }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getStartingHour() { return startingHour; }

    public void setStartingHour(String startingHour) {
        this.startingHour = startingHour;
    }

    public String getEndingHour() { return endingHour; }

    public void setEndingHour(String endingHour) {
        this.endingHour = endingHour;
    }

    public int getRouteInterval() {
        return routeInterval;
    }

    public void setRouteInterval(int routeInterval) {
        this.routeInterval = routeInterval;
    }
}
