package com.spring.controller;

import com.spring.dto.StationDTO;
import com.spring.entity.Station;
import com.spring.mappers.StationMapper;
import com.spring.service.StationService;
import com.spring.utils.ResponseHandler;
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
    public Collection<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @RequestMapping(path = "/insert", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseHandler insertNewStation(@RequestBody StationDTO newStationDTO) {

        Station newStation = StationMapper.stationDTOToEntity(newStationDTO);

        if (stationService.insertNewStation(newStation).getStatus()!="OK") {
            return null;
        }

        return new ResponseHandler("OK",newStation);
    }

    @RequestMapping(value = "/delete/{stationId}", method = RequestMethod.DELETE)
    public Boolean deleteStation(@PathVariable String stationId) {
        return stationService.deleteStation(stationId);
    }
}
