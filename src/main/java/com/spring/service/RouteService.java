package com.spring.service;

import com.spring.entity.Route;
import com.spring.repository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RouteService {
    @Autowired
    private RouteRepo rr;

    public Collection<Route> getAllRoutes(){
        return rr.getAllRoutes();
    }
}
