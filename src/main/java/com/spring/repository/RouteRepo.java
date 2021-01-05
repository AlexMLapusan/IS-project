package com.spring.repository;

import com.spring.entity.Route;
import com.spring.entity.Station;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collection;

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

    public Route addStation(String routeId, String stationId) {
        //IMPORTANT cand se incearca adaugarea unei stati deja adaugate se arunca exceptia java.lang.IllegalStateException

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StationRepo stationRepo = new StationRepo();
        Station station = stationRepo.findStation(stationId);

        //get the route
        Route route = findRoute(routeId);
        route.addStation(station);

        //update the database entry
        entityManager.getTransaction().begin();
        entityManager.merge(route);
        entityManager.getTransaction().commit();
        entityManager.close();

        return route;
    }

    public Route removeStation(String routeId, String stationId) {
        //todo verificare daca statia cu stationID exista in baza de date respectiv daca e deja in lista de statii a rutei
        // (desi teoretic o sa fie si o verificare in front end you never know)

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StationRepo stationRepo = new StationRepo();
        Station station = stationRepo.findStation(stationId);

        //get the route
        Route route = findRoute(routeId);
        route.removeStation(stationId);

        //update the database entry
        entityManager.getTransaction().begin();
        entityManager.merge(route);
        entityManager.getTransaction().commit();
        entityManager.close();

        return route;
    }

    public Boolean deleteRoute(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Route toBeDeleted = entityManager.find(Route.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(toBeDeleted);
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }
    public Boolean checkIfAliasExists(String alias){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM Route ua WHERE ua.alias=:alias";

        Query query = entityManager.createQuery(select);
        query.setParameter("alias",alias);
        entityManager.getTransaction().begin();

        try {
            Route s = (Route) query.getSingleResult();
            return true;
        }
        catch (NoResultException e){
            return false;
        }
        finally {
            entityManager.close();
        }
    }
}
