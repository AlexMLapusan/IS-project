package com.spring.controller;

import com.spring.entity.Ticket;
import com.spring.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("req/buy")
public class TicketSubsController {
    @Autowired
    private TicketService ticketService;
    @RequestMapping(path = "/ticket/{quantity}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Ticket addTickets(@PathVariable int quantity) {

        Ticket newTicket = new Ticket();
        for (int i = 0; i < quantity; i++) {
            newTicket = Ticket.createNewTicket();
            if (!ticketService.insertNewTicket(newTicket)) {
                return null;
            }
        }

        return newTicket;
    }
}
