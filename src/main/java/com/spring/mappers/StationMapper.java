package com.spring.mappers;


import com.spring.dto.StationDTO;
import com.spring.entity.Station;

import java.util.UUID;

public class StationMapper {

    public static Station stationDTOToEntity(StationDTO stationDTO){
        Station station = new Station();

        station.setId(UUID.randomUUID().toString());
        station.setAddress(stationDTO.getAddress());
        station.setName(stationDTO.getName());

        return station;
    }
}
