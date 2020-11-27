package com.spring.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    private String id;

    @Column
    private boolean valid;

    @Column
    private String validityDuration;

    @Column
    private boolean activity;

    @Column
    private Date activationTime;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Ticket() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getValidityDuration() {
        return validityDuration;
    }

    public void setValidityDuration(String validityDuration) {
        this.validityDuration = validityDuration;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public Date getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(Date activationTime) {
        this.activationTime = activationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
