package com.spring.repository;

import com.spring.entity.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class TicketRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewTicket(Ticket ticket) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();
        em.close();
    }
}
