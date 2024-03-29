package org.exam.exam_jee.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.exam.exam_jee.Models.Projet;

import java.util.List;

public class ProjectRepository {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public ProjectRepository(String name){
        entityManagerFactory = Persistence.createEntityManagerFactory(name);
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Projet> selectAll(){
        return entityManager.createNamedQuery("projet.findAll").getResultList();
    }

    public void addProject(Projet projet){
        entityManager.getTransaction().begin();
        entityManager.persist(projet);
        entityManager.getTransaction().commit();
    }

}
