package com.spring.repository;

import com.spring.entity.PriceTable;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collection;

@Repository
public class PriceTableRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewPrice(PriceTable priceTable) {
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();
        em.persist(priceTable);
        em.getTransaction().commit();

        em.close();
    }

    public PriceTable findPrice(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        PriceTable priceTable = em.find(PriceTable.class, id);
        em.close();
        return priceTable;
    }

    public PriceTable findByType(PriceTable.Type type){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT pt FROM PriceTable pt WHERE pt.type=:type";

        Query query = entityManager.createQuery(select);
        query.setParameter("type", type);
        entityManager.getTransaction().begin();

        try {
            PriceTable priceTable = (PriceTable) query.getSingleResult();
            entityManager.close();
            return priceTable;
        }
        catch (NoResultException e){
            entityManager.close();
            return null;
        }
    }

    public Collection<PriceTable> getAllPrices() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT pt FROM PriceTable pt";

        Query query = entityManager.createQuery(select);

        entityManager.getTransaction().begin();
        Collection<PriceTable> prices = query.getResultList();

        entityManager.close();
        return prices;
    }

    public boolean updatePrice(String priceId, int newPrice){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //get the route
        PriceTable priceTable = findPrice(priceId);
        priceTable.setPrice(newPrice);

        //update the database entry
        entityManager.getTransaction().begin();
        entityManager.merge(priceTable);
        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }
}
