package com.spring.controller;

import com.spring.dto.IdUniversalDTO;
import com.spring.entity.Route;
import com.spring.entity.User;
import com.spring.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/add_station/{stationId}", method = RequestMethod.PUT)
    public Route addStation(@RequestBody IdUniversalDTO routeId, @PathVariable String stationId) {
        return routeService.addStation(routeId.getId(), stationId);
    }

}
