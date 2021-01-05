package com.spring.repository;

import com.spring.entity.Station;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository
public class StationRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewStation(Station station) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(station);
        em.getTransaction().commit();
        em.close();
    }

    public Station findStation(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Station station = entityManager.find(Station.class, id);
        entityManager.close();

        return station;
    }

    public Collection<Station> getAllStations() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT r FROM Station r";

        Query query = entityManager.createQuery(select);
        entityManager.getTransaction().begin();
        Collection<Station> stations = query.getResultList();
        entityManager.close();

        return stations;
    }

    public Boolean deleteStation(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Station toBeDeleted = entityManager.find(Station.class, id);
        entityManager.getTransaction().begin();

        // remove all associations
        Query q = entityManager.createNativeQuery("DELETE FROM route_station rs WHERE rs.id_station = ?");
        q.setParameter(1, toBeDeleted.getId());
        q.executeUpdate();
        entityManager.remove(toBeDeleted);
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }

}
