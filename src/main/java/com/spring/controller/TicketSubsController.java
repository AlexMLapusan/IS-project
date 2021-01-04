package com.spring.controller;

import com.spring.dto.IdUniversalDTO;
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
    @RequestMapping(value = "/ticket/{quantity}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public Ticket addTickets(@RequestBody IdUniversalDTO userId, @PathVariable int quantity) {

        Ticket newTicket = new Ticket();
        for (int i = 0; i < quantity; i++) {
            System.out.println(userId.getId());
            newTicket = ticketService.createNewTicket(userId.getId());
            if (!ticketService.insertNewTicket(newTicket)) {
                return null;
            }
        }

        return newTicket;
    }
}
