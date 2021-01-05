package com.spring.service;

import com.spring.entity.Route;
import com.spring.entity.RouteSubscription;
import com.spring.repository.RouteRepo;
import com.spring.repository.RouteSubscriptionRepo;
import com.spring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouteSubscriptionService {
    @Autowired
    private RouteSubscriptionRepo routeSubscriptionRepo;

    public RouteSubscription createNew1RouteSubscription(String userId, String routeID) {
        UserRepo userRepo = new UserRepo();
        RouteRepo routeRepo = new RouteRepo();
        RouteSubscription routeSubscription = new RouteSubscription();
        List<Route> routes = new ArrayList<Route>();
        Calendar calendar = Calendar.getInstance();

        routeSubscription.setId(UUID.randomUUID().toString());
        routeSubscription.setUser(userRepo.findUser(userId));

        routeSubscription.setCreateDate(calendar.getTime());
        calendar.add(Calendar.MONTH, 1);
        routeSubscription.setExpiryDate(calendar.getTime());

        routeSubscription.setType(RouteSubscription.Type._1_ROUTE_SUBSCRIPTION);
        routes.add(routeRepo.findRoute(routeID));
        routeSubscription.setRoutes(routes);

        return routeSubscription;
    }

    public RouteSubscription createNew2RoutesSubscription(String userId, String route1ID, String route2ID){
        UserRepo userRepo = new UserRepo();
        RouteRepo routeRepo = new RouteRepo();
        RouteSubscription routeSubscription = new RouteSubscription();
        List<Route> routes = new ArrayList<Route>();
        Calendar calendar = Calendar.getInstance();

        routeSubscription.setId(UUID.randomUUID().toString());
        routeSubscription.setUser(userRepo.findUser(userId));

        routeSubscription.setCreateDate(calendar.getTime());
        calendar.add(Calendar.MONTH, 1);
        routeSubscription.setExpiryDate(calendar.getTime());

        routeSubscription.setType(RouteSubscription.Type._2_ROUTES_SUBSCRIPTION);
        routes.add(routeRepo.findRoute(route1ID));
        routes.add(routeRepo.findRoute(route2ID));
        routeSubscription.setRoutes(routes);

        return routeSubscription;
    }

    public boolean insertNewSubscription(RouteSubscription routeSubscription) {
        //todo validari, schimbare tip returnat, all the good stuff

        routeSubscriptionRepo.insertNewSubscription(routeSubscription);
        return true;
    }
}
