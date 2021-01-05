package com.spring.repository;

import com.spring.entity.Admin;
import com.spring.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;


@Repository
public class AdminRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewAdmin(Admin admin) {
        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();

        em.close();
    }

    public Admin findUser(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Admin admin = em.find(Admin.class,id);
        em.close();
        return admin;
    }

    public Admin findAdminByEmailAndPass(String email, String pass) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM Admin ua WHERE ua.email=:email and ua.password=:password";

        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        query.setParameter("password", pass);
        entityManager.getTransaction().begin();

        try {
            Admin u = (Admin) query.getSingleResult();
            return u;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    public Boolean checkIfEmailExist(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM Admin ua WHERE ua.email=:email";

        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        entityManager.getTransaction().begin();

        try {
            Admin u = (Admin) query.getSingleResult();
            return true;
        }
        catch (NoResultException e){
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    public Admin updateAdmin(Admin admin) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(admin);
        entityManager.getTransaction().commit();

        entityManager.close();
        return admin;
    }

    public Boolean checkEmailExistForAnotherId (String email, String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM Admin ua WHERE ua.email=:email AND ua.id<>:id";

        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        query.setParameter("id", id);
        entityManager.getTransaction().begin();

        try {
            Admin u = (Admin) query.getSingleResult();
            return true;
        }
        catch (NoResultException e){
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    public Admin findAdminByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String select = "SELECT ua FROM Admin ua WHERE ua.email=:email";

        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        entityManager.getTransaction().begin();

        try {
            Admin ad = (Admin) query.getSingleResult();
            return ad;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            entityManager.close();
        }
    }
}
