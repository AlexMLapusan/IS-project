package com.spring.service;

import com.spring.entity.Route;
import com.spring.repository.RouteRepo;
import com.spring.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RouteService {
    @Autowired
    private RouteRepo routeRepo;

    public Collection<Route> getAllRoutes() {
        return routeRepo.getAllRoutes();
    }

    public Route addStation(String routeId, String stationId) {

        return routeRepo.addStation(routeId, stationId);
    }

    public Route removeStation(String routeId, String stationId) {
        return routeRepo.removeStation(routeId, stationId);
    }

    public boolean deleteRoute(String routeId) {

        Boolean allGood= routeRepo.deleteRoute(routeId);
        return allGood;
    }

    public ResponseHandler insertNewRoute(Route route) {

        if(routeRepo.checkIfAliasExists(route.getAlias())){
            return new ResponseHandler("ERR","name");
        }else{
            routeRepo.insertNewRoute(route);
            return new ResponseHandler("OK","");
        }
    }

}

