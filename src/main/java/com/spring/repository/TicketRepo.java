package com.spring.repository;

import com.spring.entity.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

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

    public Ticket useTicket(Ticket ticket) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Date date = new Date(System.currentTimeMillis());
        ticket.setActivationTime(date);
        ticket.setActivity(true);

        //update the database user
        entityManager.getTransaction().begin();
        entityManager.merge(ticket);
        entityManager.getTransaction().commit();
        entityManager.close();

        return ticket;
    }
}
