package com.spring.service;

import com.spring.entity.Station;
import com.spring.repository.StationRepo;
import com.spring.utils.ResponseHandler;
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

    public ResponseHandler insertNewStation(Station station){
        //todo validari, schimbare tip returnat, all the good stuff--done
        if(stationRepo.checkIfNameExists(station.getName())){
            return new ResponseHandler("ERR","name");
        }else{
            stationRepo.insertNewStation(station);
            return new ResponseHandler("OK","");
        }
    }

    public Boolean deleteStation(String stationId){
        //todo validari si returnare valori relevante--done i guess
        Boolean allGood =  stationRepo.deleteStation(stationId);

        return allGood;
    }

}
