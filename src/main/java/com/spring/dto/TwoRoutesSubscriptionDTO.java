package com.spring.dto;

public class TwoRoutesSubscriptionDTO {
    private String userID;
    private String route1ID;
    private String route2ID;

    private TwoRoutesSubscriptionDTO(String userID, String route1ID, String route2ID) {
        this.userID = userID;
        this.route1ID = route1ID;
        this.route2ID = route2ID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserId(String userId) {
        this.userID = userId;
    }

    public String getRoute1ID() {
        return route1ID;
    }

    public void setRoute1ID(String route1ID) {
        this.route1ID = route1ID;
    }

    public String getRoute2ID() {
        return route2ID;
    }

    public void setRoute2ID(String route2ID) {
        this.route2ID = route2ID;
    }
}
