package com.spring.controller;

import com.spring.dto.IdUniversalDTO;
import com.spring.dto.TwoRoutesSubscriptionDTO;
import com.spring.entity.*;
import com.spring.service.*;
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
    @Autowired
    PriceTableService priceTableService;
    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/ticket/{quantity}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public Ticket addTickets(@RequestBody IdUniversalDTO userId, @PathVariable int quantity) {

        Ticket newTicket = new Ticket();
        float price = priceTableService.findByType(PriceTable.Type.TICKET).getPrice();
        Transaction transaction = new Transaction();
        for (int i = 0; i < quantity; i++) {
            newTicket = ticketService.createNewTicket(userId.getId());
            if (!ticketService.insertNewTicket(newTicket)) {
                return null;
            }
            transaction = transactionService.createNewTransaction(newTicket.getId(), Transaction.Type.TICKET, price);
            if (!transactionService.insertNewTransaction(transaction)) {
                return null;
            }
        }

        return newTicket;
    }

    @RequestMapping(value = "/trip_sub/{type}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public TripsSubscription addTripSub(@RequestBody IdUniversalDTO userId, @PathVariable Integer type) {
        TripsSubscription ts =  tripSubscriptionService.createNewSubscription(userId.getId(), type);
        String tsType = ts.getType().name();
        float price = priceTableService.findByType(PriceTable.Type.valueOf(tsType)).getPrice();
        Transaction transaction = transactionService.createNewTransaction(ts.getId(), Transaction.Type.valueOf(tsType), price);
        if (!tripSubscriptionService.insertNewSubscription(ts))
            return null;
        if (!transactionService.insertNewTransaction(transaction)) {
            return null;
        }
        return ts;
    }

    @RequestMapping(value = "/route_1_sub/{routeID}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public RouteSubscription addTripSub(@RequestBody IdUniversalDTO userId, @PathVariable String routeID) {
        RouteSubscription routeSubscription = routeSubscriptionService.createNew1RouteSubscription(userId.getId(), routeID);
        float price = priceTableService.findByType(PriceTable.Type._1_ROUTE_SUBSCRIPTION).getPrice();
        Transaction transaction = transactionService.createNewTransaction(routeSubscription.getId(), Transaction.Type._1_ROUTE_SUBSCRIPTION, price);
        if (!routeSubscriptionService.insertNewSubscription(routeSubscription))
            return null;
        if (!transactionService.insertNewTransaction(transaction)) {
            return null;
        }

        return routeSubscription;
    }

    @RequestMapping(value = "/route_2_sub/", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public RouteSubscription add2TripSub(@RequestBody TwoRoutesSubscriptionDTO dto) {
        System.out.println(dto.getUserID());
        RouteSubscription routeSubscription =
                routeSubscriptionService.createNew2RoutesSubscription(dto.getUserID(), dto.getRoute1ID(), dto.getRoute2ID());
        float price = priceTableService.findByType(PriceTable.Type._2_ROUTES_SUBSCRIPTION).getPrice();
        Transaction transaction = transactionService.createNewTransaction(routeSubscription.getId(), Transaction.Type._2_ROUTES_SUBSCRIPTION, price);

        if (!routeSubscriptionService.insertNewSubscription(routeSubscription))
            return null;
        if (!transactionService.insertNewTransaction(transaction)) {
            return null;
        }
        return routeSubscription;
    }
}
