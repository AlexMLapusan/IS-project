package com.spring.entity;

import com.spring.utils.Utils;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    private String id;

    @Column
    private boolean valid;

    @Column
    private int validityDuration;

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

    public int getValidityDuration() {
        return validityDuration;
    }

    public void setValidityDuration(int validityDuration) {
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

    public void setUser(User user) {
        this.user = user;
    }
}
