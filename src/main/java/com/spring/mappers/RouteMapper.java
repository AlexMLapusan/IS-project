package com.spring.mappers;
import com.spring.dto.RouteDTO;
import com.spring.entity.Route;

import java.util.UUID;

public class RouteMapper {
    public static Route routeDTOToEntity(RouteDTO routeDTO) {
        Route route =new Route();

        route.setId(UUID.randomUUID().toString());
        route.setAlias(routeDTO.getAlias());
        route.setStartingHour(routeDTO.getStartingHour());
        route.setEndingHour(routeDTO.getEndingHour());
        route.setRouteInterval(routeDTO.getRouteInterval());

        return route;
    }
}
