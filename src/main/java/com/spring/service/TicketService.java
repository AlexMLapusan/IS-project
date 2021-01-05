package com.spring.service;

import com.spring.entity.Ticket;
import com.spring.repository.TicketRepo;
import com.spring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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

    public Ticket createNewTicket(String userId){
        UserRepo userRepo = new UserRepo();
        Ticket newTicket = new Ticket();
        newTicket.setId(UUID.randomUUID().toString());
        newTicket.setValid(true);
        newTicket.setValidityDuration(30);
        newTicket.setActivity(false);
        newTicket.setUser(userRepo.findUser(userId));

        return newTicket;
    }
}
