package com.spring.service;

import com.spring.entity.Ticket;
import com.spring.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    public Boolean insertNewTicket(Ticket ticket){
        //todo validari, schimbare tip returnat, all the good stuff
        ticketRepo.insertNewTicket(ticket);
        return true;
    }

    public static Ticket createNewTicket(String userId){
        UserService userService = new UserService();
        Ticket newTicket = new Ticket();
        newTicket.setId(UUID.randomUUID().toString());
        newTicket.setValid(true);
        newTicket.setValidityDuration(30);
        newTicket.setActivity(false);
        newTicket.setUser(userService.findUserById(userId));

        return newTicket;
    }
}
