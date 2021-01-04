package com.spring.entity;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
public class User {

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private boolean confirmed;

    @Column
    private String image;

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "user")
    private List<TicketSubscription> ticketSubscriptions;

    @OneToMany(mappedBy = "user")
    private List<RouteSubscription> routeSubscriptions;

    public User() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getImage() {
        return image;
    }

    /**
     * @return the id of the activated ticket
     */
    public Ticket useTicket() {
        List<Ticket> unusedTickets = this.tickets.stream().filter(ticket -> !ticket.isActivity()).collect(Collectors.toList());
        if(unusedTickets.isEmpty())
            return null;
        Ticket ticket = unusedTickets.get(0);
        return ticket;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
