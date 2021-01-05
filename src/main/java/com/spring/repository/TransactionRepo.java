package com.spring.repository;

import com.spring.entity.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class TransactionRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewTransaction(Transaction transaction) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
        em.close();
    }

    public Collection<Transaction> getAllTransactions() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT t FROM Transaction t";

        Query query = entityManager.createQuery(select);

        entityManager.getTransaction().begin();
        Collection<Transaction> transactions = query.getResultList();

        entityManager.close();
        return transactions;
    }
}
