package com.spring.controller;

import com.spring.dto.IdUniversalDTO;
import com.spring.dto.TwoRoutesSubscriptionDTO;
import com.spring.entity.RouteSubscription;
import com.spring.entity.Ticket;
import com.spring.entity.TripsSubscription;
import com.spring.service.RouteSubscriptionService;
import com.spring.service.TicketService;
import com.spring.service.TripSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("req/buy")
public class TicketSubsController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TripSubscriptionService tripSubscriptionService;
    @Autowired
    RouteSubscriptionService routeSubscriptionService;

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

    @RequestMapping(value = "/trip_sub/{type}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public TripsSubscription addTripSub(@RequestBody IdUniversalDTO userId, @PathVariable Integer type) {
        TripsSubscription ts =  tripSubscriptionService.createNewSubscription(userId.getId(), type);

        if (!tripSubscriptionService.insertNewSubscription(ts))
            return null;

        return ts;
    }

    @RequestMapping(value = "/route_1_sub/{routeID}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public RouteSubscription addTripSub(@RequestBody IdUniversalDTO userId, @PathVariable String routeID) {
        RouteSubscription routeSubscription = routeSubscriptionService.createNew1RouteSubscription(userId.getId(), routeID);

        if (!routeSubscriptionService.insertNewSubscription(routeSubscription))
            return null;

        return routeSubscription;
    }

    @RequestMapping(value = "/route_2_sub/", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public RouteSubscription add2TripSub(@RequestBody TwoRoutesSubscriptionDTO dto) {
        System.out.println(dto.getUserID());
        RouteSubscription routeSubscription =
                routeSubscriptionService.createNew2RoutesSubscription(dto.getUserID(), dto.getRoute1ID(), dto.getRoute2ID());

        if (!routeSubscriptionService.insertNewSubscription(routeSubscription))
            return null;

        return routeSubscription;
    }
}
