package com.spring.controller;

import com.spring.entity.Route;
import com.spring.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("req/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}
