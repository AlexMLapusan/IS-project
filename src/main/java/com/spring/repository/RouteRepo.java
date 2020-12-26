package com.spring.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.entity.Route;
import com.spring.entity.Station;
import com.spring.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository
public class RouteRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewRoute(Route route) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(route);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public Collection<Route> getAllRoutes() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT r FROM Route r";

        Query query = entityManager.createQuery(select);

        entityManager.getTransaction().begin();
        Collection<Route> routes = query.getResultList();

        entityManager.close();
        return routes;
    }

    public Route findRoute(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Route route = entityManager.find(Route.class, id);
        entityManager.close();

        return route;
    }

    @JsonIgnore
    public Route addStation(String routeId, String stationId) {
        //todo verificare daca statia cu stationID exista in baza de date respectiv daca e deja in lista de statii a rutei
        // (desi teoretic o sa fie si o verificare in front end you never know)

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StationRepo stationRepo = new StationRepo();
        Station station = stationRepo.findStation(stationId);

        //get the route
        Route route = findRoute(routeId);

        //update stations list
        List<Station> stationList = route.getStations();
        stationList.add(station);
        route.setStations(stationList);

        //update the database entry
        entityManager.getTransaction().begin();
        entityManager.merge(route);
        entityManager.getTransaction().commit();
        entityManager.close();

        return route;
    }
}
