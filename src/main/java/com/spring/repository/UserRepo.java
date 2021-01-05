package com.spring.repository;

import com.spring.dto.RegisterUserDTO;
import com.spring.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collection;

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

    public Boolean checkIfEmailExist(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM User ua WHERE ua.email=:email";

        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        entityManager.getTransaction().begin();

        try {
            User u = (User) query.getSingleResult();
            return true;
        }
        catch (NoResultException e){
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    public Boolean checkEmailExistForAnotherId (String email, String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM User ua WHERE ua.email=:email AND ua.id<>:id";

        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        query.setParameter("id", id);
        entityManager.getTransaction().begin();

        try {
            User u = (User) query.getSingleResult();
            return true;
        }
        catch (NoResultException e){
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    public User findUserByEmailAndPass(String email, String pass) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM User ua WHERE ua.email=:email and ua.password=:password";

        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        query.setParameter("password", pass);
        entityManager.getTransaction().begin();

        try {
            User u = (User) query.getSingleResult();
            return u;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    public Collection<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT a FROM User a";

        Query query = entityManager.createQuery(select);

        entityManager.getTransaction().begin();
        Collection<User> users = query.getResultList();

        entityManager.close();
        return users;
    }


    public User updateUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();

        entityManager.close();
        return user;
    }

    public Boolean deleteUser(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User toBeDeleted = entityManager.find(User.class, id);
        entityManager.getTransaction().begin();

        // remove all associations for this user
        Query q = entityManager.createNativeQuery("DELETE FROM Ticket t WHERE t.id_user = ?");
        q.setParameter(1, toBeDeleted.getId());
        q.executeUpdate();

        q = entityManager.createNativeQuery("DELETE FROM route_subscription rs WHERE rs.id_user = ?");
        q.setParameter(1, toBeDeleted.getId());
        q.executeUpdate();

        q = entityManager.createNativeQuery("DELETE FROM trip_subscription ts WHERE ts.id_user = ?");
        q.setParameter(1, toBeDeleted.getId());
        q.executeUpdate();

        entityManager.remove(toBeDeleted);
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }


    public User findUserByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM User ua WHERE ua.email=:email";

        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        entityManager.getTransaction().begin();

        try {
            User u = (User) query.getSingleResult();
            return u;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            entityManager.close();
        }
    }
}
