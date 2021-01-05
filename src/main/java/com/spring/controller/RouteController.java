package com.spring.controller;

import com.spring.dto.IdUniversalDTO;
import com.spring.dto.RouteDTO;
import com.spring.entity.Route;
import com.spring.mappers.RouteMapper;
import com.spring.service.RouteService;
import com.spring.utils.ResponseHandler;
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

    @RequestMapping(value = "/remove_station/{stationId}", method = RequestMethod.PUT)
    public Route deleteStation(@RequestBody IdUniversalDTO routeId, @PathVariable String stationId) {
        return routeService.removeStation(routeId.getId(), stationId);
    }

    @RequestMapping(value = "/delete/{routeId}", method = RequestMethod.DELETE)
    public boolean deleteRoute(@PathVariable String routeId) {
        return routeService.deleteRoute(routeId);
    }


    @RequestMapping(path = "/insert", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseHandler insertNewRoute(@RequestBody RouteDTO newRouteDTO) {

        Route newRoute = RouteMapper.routeDTOToEntity(newRouteDTO);

        if (routeService.insertNewRoute(newRoute).getStatus()!="OK") {
            return null;
        }

        return new ResponseHandler("OK",newRoute);
    }
}
