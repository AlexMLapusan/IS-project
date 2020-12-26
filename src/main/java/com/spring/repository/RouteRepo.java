package com.spring.repository;

import com.spring.entity.Route;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class RouteRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewRoute(Route route) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(route);
        em.getTransaction().commit();
        em.close();
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
}
