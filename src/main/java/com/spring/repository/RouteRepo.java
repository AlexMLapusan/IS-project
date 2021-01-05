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

    public Route addStation(String routeId, String stationId) {
        //todo verificare daca statia cu stationID exista in baza de date respectiv daca e deja in lista de statii a rutei
        // (desi teoretic o sa fie si o verificare in front end you never know)

        //IMPORTANT cand se incearca adaugarea unei stati deja adaugate se arunca exceptia java.lang.IllegalStateException
        //use this info wisely

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

        // get all subs with the route to delete
        Query q = entityManager.createNativeQuery("SELECT rs.id_subscription FROM rs_routes rs JOIN route_subscription r ON rs.id_subscription = r.id " +
                "JOIN rs_routes rs2 ON r.id = rs2.id_subscription WHERE rs2.id_route = ? GROUP BY rs.id_subscription");
        q.setParameter(1, toBeDeleted.getId());
        List<String> subIds = (List<String>)q.getResultList();

        // remove all associations
        q = entityManager.createNativeQuery("DELETE FROM rs_routes rs WHERE rs.id_subscription in (:ids)");
        q.setParameter("ids", subIds);
        q.executeUpdate();

        // remove all subs
        q = entityManager.createNativeQuery("DELETE FROM route_subscription r WHERE r.id IN (:ids)");
        q.setParameter("ids", subIds);
        q.executeUpdate();

        entityManager.remove(toBeDeleted);
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }
}
