package com.spring.service;

import com.spring.entity.Ticket;
import com.spring.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    public Boolean insertNewTicket(Ticket ticket){
        //todo validari, schimbare tip returnat, all the good stuff
        ticketRepo.insertNewTicket(ticket);
        return true;
    }
}
