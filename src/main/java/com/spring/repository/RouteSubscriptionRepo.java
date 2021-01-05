package com.spring.repository;

import com.spring.entity.RouteSubscription;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class RouteSubscriptionRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewSubscription(RouteSubscription routeSubscription) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(routeSubscription);
        em.getTransaction().commit();
        em.close();
    }
}
