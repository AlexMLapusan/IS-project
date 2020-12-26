package com.spring.controller;

import com.spring.dto.RegisterUserDTO;
import com.spring.dto.StationDTO;
import com.spring.entity.Station;
import com.spring.entity.User;
import com.spring.mappers.StationMapper;
import com.spring.mappers.UserMapper;
import com.spring.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("req/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<Station> getAllRoutes() {
        return stationService.getAllStations();
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Station insertNewStation(@RequestBody StationDTO newStationDTO) {

        Station newStation = StationMapper.stationDTOToEntity(newStationDTO);

        if (!stationService.insertNewStation(newStation)) {
            return null;
        }

        return newStation;
    }
}
