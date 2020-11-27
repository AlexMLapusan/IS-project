package com.spring.repository;

import com.spring.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository
public class UserRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public User findUser(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user =	em.find(User.class,id);
        em.close();
        return user;
    }

    public User findUserByEmailAndPass(String email, String pass) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM User ua WHERE ua.email=:userName and ua.password=:password";

        Query query = entityManager.createQuery(select);
        query.setParameter("userName", email);
        query.setParameter("password", pass);

        entityManager.getTransaction().begin();
        User u = (User) query.getSingleResult();

        entityManager.close();
        return u;
    }

    public Collection<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM User ua";

        Query query = entityManager.createQuery(select);

        entityManager.getTransaction().begin();
        Collection<User> users = query.getResultList();

        entityManager.close();
        return users;
    }
}
