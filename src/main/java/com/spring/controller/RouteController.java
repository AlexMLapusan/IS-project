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
    public Route addRoute(@RequestBody IdUniversalDTO routeId, @PathVariable String stationId) {
        return routeService.addStation(routeId.getId(), stationId);
    }

    @RequestMapping(value = "/delete/{routeId}", method = RequestMethod.DELETE)
    public boolean deleteRoute(@PathVariable String routeId) {
        return routeService.deleteRoute(routeId);
    }

    //todo insert pentru ruta, pasi ar fi :
    // - de facut dto pentru ruta (in care avem doar alias, start hour, end hour, interval)
    // - de facut mapper asemanator cu mapper-u pentru statie in care avem o metoda de la dto la entitate
    // - de schimbat functia comentata mai jos sa se potriveasca pentru Route (tipurile de date folosite din StationDTO in RouteDTO..etc)
    // - de creat functiile necesare in RouteService si RouteRepo (flow identic cu cel pentru station)

    //@RequestMapping(path = "/insert", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    //    public Station insertNewStation(@RequestBody StationDTO newStationDTO) {
    //
    //        Station newStation = StationMapper.stationDTOToEntity(newStationDTO);
    //
    //        if (!stationService.insertNewStation(newStation)) {
    //            return null;
    //        }
    //
    //        return newStation;
    //    }
}
