package org.exam.exam_jee.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.exam.exam_jee.Config.DB;
import org.exam.exam_jee.Models.Employee;
import org.exam.exam_jee.Models.Projet;

import java.util.List;

public class ProjectRepository {

    EntityManager entityManager;

    public ProjectRepository(){
        entityManager = DB.getEntityManager();
    }

    public List<Projet> selectAll(){
        DB.clearCache();
        return entityManager.createNamedQuery("projet.findAll").getResultList();
    }

    public void addProject(Projet projet){
        entityManager.getTransaction().begin();
        entityManager.persist(projet);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public Projet find(Long id){
        return entityManager.find(Projet.class, id);
    }

}
