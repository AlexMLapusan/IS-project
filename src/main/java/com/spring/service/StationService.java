package com.spring.service;

import com.spring.dto.StationDTO;
import com.spring.entity.Station;
import com.spring.repository.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StationService {
    @Autowired
    private StationRepo stationRepo;

    public Collection<Station> getAllStations(){
        return stationRepo.getAllStations();
    }

    public Boolean insertNewStation(Station station){
        //todo validari, schimbare tip returnat, all the good stuff
        stationRepo.insertNewStation(station);
        return true;
    }

}
