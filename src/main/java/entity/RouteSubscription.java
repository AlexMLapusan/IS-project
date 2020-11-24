package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "route_subscription")
public class RouteSubscription {

    @Id
    private String id;

    @Column
    private int ticketCount;

    @Column
    private Date createDate;

    @Column
    private Date expiryDate;

    public RouteSubscription() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
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
}
